package be.inniger.homepage.web;

import be.inniger.homepage.service.TmpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TmpControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@MockBean
	private TmpService tmpService;

	@Test
	public void tmpTest() {
		when(tmpService.tmpSet()).thenReturn(Set.of(-1L));

		String response = restTemplate.getForObject("/tmp-rest", String.class);

		assertThat(response)
				.isEqualTo("{\"key\":\"Hello\",\"value\":[-1]}");
	}
}
