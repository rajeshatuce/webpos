package com.dazzlersoft.webpos.dao;

import java.util.List;

import com.dazzlersoft.webpos.model.Item;

public interface ItemDao {
	public void persist(Item transientInstance);
	public void attachDirty(Item instance);
	public void attachClean(Item instance);
	public void delete(Item persistentInstance);
	public Item merge(Item detachedInstance);
	public Item findById(long id);
	public List<Item> findByExample(Item instance);
}
