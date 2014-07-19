package com.dazzlersoft.webpos.dao;

import java.util.List;

import com.dazzlersoft.webpos.model.Category;

public interface CategoryDao {
	
	public void persist(Category transientInstance) ;
	
	public void attachDirty(Category instance);
	
	public void attachClean(Category instance);
	
	public void delete(Category persistentInstance);
	
	public Category merge(Category detachedInstance);
	
	public Category findById(long id);
	
	public List<Category> findByExample(Category instance);
	
	public List<Category> fetchAllCategory();
	
	

}
