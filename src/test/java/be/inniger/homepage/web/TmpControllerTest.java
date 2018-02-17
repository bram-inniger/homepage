package be.inniger.homepage.web;

import be.inniger.homepage.dao.TmpDao;
import be.inniger.homepage.service.TmpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TmpControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@MockBean
	private TmpService tmpService;

	@Autowired
	private TmpDao tmpDao;

	@Test
	public void tmpRealTest() {
		when(tmpService.tmpList()).thenReturn(tmpDao.list());

		String response = restTemplate.getForObject("/tmp-rest", String.class);

		assertThat(response)
				.isEqualTo("{\"key\":\"Hello\",\"value\":[42,-9223372036854775808,9223372036854775807]}");
	}

	@Test
	public void tmpMockedTest() {
		when(tmpService.tmpList()).thenReturn(List.of(-1L));

		String response = restTemplate.getForObject("/tmp-rest", String.class);

		assertThat(response)
				.isEqualTo("{\"key\":\"Hello\",\"value\":[-1]}");
	}
}
