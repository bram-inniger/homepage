package be.inniger.homepage.service;

import be.inniger.homepage.dao.TmpDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TmpService {

	private final TmpDao tmpDao;

	@Autowired
	public TmpService(TmpDao tmpDao) {
		this.tmpDao = tmpDao;
	}

	public List<Long> tmpList() {
		return tmpDao.list();
	}
}
