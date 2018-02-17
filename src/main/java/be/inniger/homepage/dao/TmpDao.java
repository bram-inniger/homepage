package be.inniger.homepage.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class TmpDao {

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public TmpDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void create(long number) {
		jdbcTemplate.update("INSERT INTO numbers " +
						"  (number) " +
						"  VALUES " +
						"  (?)",
				number);

		log.info("Created new record: {}", number);
	}

	public List<Long> list() {
		List<Long> numbers = jdbcTemplate.queryForList("SELECT number FROM numbers", Long.class);

		log.info("Read from DB: {}", numbers);

		return numbers;
	}
}
