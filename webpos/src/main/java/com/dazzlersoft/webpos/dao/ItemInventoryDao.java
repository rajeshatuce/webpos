package com.dazzlersoft.webpos.dao;

import java.util.List;

import com.dazzlersoft.webpos.model.ItemInventory;

public interface ItemInventoryDao {
	public void persist(ItemInventory transientInstance);
	public void attachDirty(ItemInventory instance);
	public void attachClean(ItemInventory instance);
	public void delete(ItemInventory persistentInstance);
	public ItemInventory merge(ItemInventory detachedInstance);
	public ItemInventory findById(long id);
	public List<ItemInventory> findByInventoryIdList(List<Long> iventoryIdList);
	public List<ItemInventory> findByExample(ItemInventory instance);
}
