package be.inniger.homepage.web;

import be.inniger.homepage.service.TmpService;
import be.inniger.homepage.web.response.TmpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/tmp-rest")
@RestController
public class TmpController {

	private final TmpService tmpService;

	@Autowired
	public TmpController(TmpService tmpService) {
		this.tmpService = tmpService;
	}

	@GetMapping
	public TmpResponse<String, List<Long>> tmp() {
		return TmpResponse.of("Hello", tmpService.tmpList());
	}
}
