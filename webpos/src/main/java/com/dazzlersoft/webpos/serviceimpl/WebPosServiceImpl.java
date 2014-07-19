package com.dazzlersoft.webpos.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dazzlersoft.webpos.dao.CategoryDao;
import com.dazzlersoft.webpos.model.Category;
import com.dazzlersoft.webpos.service.WebPosService;

@Service
public class WebPosServiceImpl implements WebPosService {
	@Autowired
	private CategoryDao categoryDao;

	@Transactional
	public List<Category> fetchAllCategory() {
		return categoryDao.fetchAllCategory();
	}

}
