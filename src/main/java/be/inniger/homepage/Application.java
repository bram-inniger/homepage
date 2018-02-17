package be.inniger.homepage;

import be.inniger.homepage.dao.TmpDao;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.stream.Stream;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private final TmpDao tmpDao;
	private final Flyway flyway;

	@Autowired
	public Application(TmpDao tmpDao, Flyway flyway) {
		this.tmpDao = tmpDao;
		this.flyway = flyway;
	}

	public static void main(String... args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) {
		// Clean up data from previous runs
		flyway.clean();
		flyway.migrate();

		Stream.of(42L, Long.MIN_VALUE, Long.MAX_VALUE)
				.forEach(tmpDao::create);
	}
}
