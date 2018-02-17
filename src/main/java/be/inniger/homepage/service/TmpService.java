package be.inniger.homepage.service;

import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class TmpService {

	public Set<Long> tmpSet() {
		return Set.of(42L, 0L, Long.MAX_VALUE, Long.MIN_VALUE);
	}
}
