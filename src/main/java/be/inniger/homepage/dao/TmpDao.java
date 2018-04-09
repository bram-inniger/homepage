package be.inniger.homepage.dao;

import org.jooq.DSLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static generated.Tables.NUMBERS;

@Repository
public class TmpDao {

	private static final Logger log = LoggerFactory.getLogger(TmpDao.class);
	private final DSLContext dsl;

	@Autowired
	public TmpDao(DSLContext dsl) {
		this.dsl = dsl;
	}

	public void create(long number) {
		dsl.insertInto(NUMBERS)
				.set(NUMBERS.NUMBER, number)
				.execute();

		log.info("Created new record: {}", number);
	}

	public List<Long> list() {
		List<Long> numbers = dsl.selectFrom(NUMBERS)
				.fetch(NUMBERS.NUMBER);

		log.info("Read from DB: {}", numbers);

		return numbers;
	}
}
