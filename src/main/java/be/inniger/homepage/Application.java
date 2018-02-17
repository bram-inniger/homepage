package be.inniger.homepage;

import be.inniger.homepage.dao.TmpDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.stream.Stream;

@Slf4j
@SpringBootApplication
public class Application implements CommandLineRunner {

	private final JdbcTemplate jdbcTemplate;
	private final TmpDao tmpDao;

	@Autowired
	public Application(JdbcTemplate jdbcTemplate, TmpDao tmpDao) {
		this.jdbcTemplate = jdbcTemplate;
		this.tmpDao = tmpDao;
	}

	public static void main(String... args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) {
		log.info("Setting up the DB");
		jdbcTemplate.execute("DROP TABLE IF EXISTS numbers");
		jdbcTemplate.execute("CREATE TABLE numbers (" +
				"  id       BIGSERIAL   PRIMARY KEY, " +
				"  number   BIGINT      NOT NULL" +
				")");

		Stream.of(42L, Long.MIN_VALUE, Long.MAX_VALUE)
				.peek(number -> log.info("Inserting in DB: {}", number))
				.forEach(tmpDao::create);
	}
}
