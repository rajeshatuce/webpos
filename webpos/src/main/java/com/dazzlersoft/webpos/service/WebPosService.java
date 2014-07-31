package com.dazzlersoft.webpos.service;

import java.util.List;

import com.dazzlersoft.webpos.model.Category;
import com.dazzlersoft.webpos.model.Product;
import com.dazzlersoft.webposutil.WebPosGenericException;

public interface WebPosService {
	
	public List<Category> fetchAllCategory();
	
	public List<Product> getProductsForCategory(Long categoryId);
	
	public byte[] getImageFromRepository(String imageId) throws WebPosGenericException;
	
	public void addImage() throws Exception;
	
	public Product getSelectedProductDetail(Long itemInventoryId);

}
