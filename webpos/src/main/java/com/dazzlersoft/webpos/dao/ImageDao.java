package com.dazzlersoft.webpos.dao;

import java.util.List;

import com.dazzlersoft.webpos.model.Image;

public interface ImageDao {
	
	public void persist(Image transientInstance);
	public void attachDirty(Image instance);
	public void attachClean(Image instance);
	public void delete(Image persistentInstance);
	public Image merge(Image detachedInstance);
	public Image findById(long id) ;
	public List<Image> findByExample(Image instance);

}
