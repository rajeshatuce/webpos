package com.dazzlersoft.webpos.serviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dazzlersoft.webpos.dao.CategoryDao;
import com.dazzlersoft.webpos.dao.ContentRepositoryDao;
import com.dazzlersoft.webpos.dao.ItemInventoryDao;
import com.dazzlersoft.webpos.model.Category;
import com.dazzlersoft.webpos.model.Item;
import com.dazzlersoft.webpos.model.ItemInventory;
import com.dazzlersoft.webpos.model.Product;
import com.dazzlersoft.webpos.service.WebPosService;
import com.dazzlersoft.webposutil.WebPosConstants;
import com.dazzlersoft.webposutil.WebPosGenericException;
import com.dazzlersoft.webposutil.WebPosUtility;

@Service
public class WebPosServiceImpl implements WebPosService {
	
	private static final Log LOG = LogFactory.getLog(WebPosServiceImpl.class);

	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private ContentRepositoryDao dao;
	@Autowired
	private ItemInventoryDao itemInventoryDao;

	@Transactional
	public List<Category> fetchAllCategory() {
		return categoryDao.fetchAllCategory();
	}

	@Transactional
	public List<Product> getProductsForCategory(Long categoryId) {
		List<Product> result=new ArrayList<Product>();
		if(categoryId==null||categoryId==0l){
			LOG.debug("Processing request for whats new page");
		}else{
			findProductForCategory(categoryId, result);
		}
		return result;

	}

	private void findProductForCategory(Long categoryId, List<Product> result) {
		Category category=categoryDao.findById(categoryId);
		Date sysDate=new Date();
		Set<Item> items=category.getItems();
		for(Item item:items){
			if(WebPosConstants.ACTIVE.equals(item.getActivityStatus())){
				Set<ItemInventory> inventories=item.getItemInventories();
				for(ItemInventory inventory:inventories){
					if(WebPosConstants.ACTIVE.equals(inventory.getActivityStatus())&&
							inventory.getQuantityAvailable()>0&&
							(sysDate.compareTo(inventory.getStartDate())>=0 && (inventory.getEndDate()==null||sysDate.compareTo(inventory.getEndDate())<=0))&&
							inventory.getImage()!=null){
						Product product=new Product();
						product.setProductName(item.getItemName());
						product.setProductPrice(WebPosUtility.formatNumber(inventory.getUnitPrice()));
						product.setProductImageUrl(inventory.getImage().getImageKey());
						product.setInventoryId(inventory.getItemInventoryId());
						result.add(product);
					}

				}
			}
		}
	}

	public byte[] getImageFromRepository(String imageId) throws WebPosGenericException {
		return dao.getImageContent(imageId);
	}

	public void addImage() throws Exception{
		dao.addContent();
		
	}

	@Transactional
	public Product getSelectedProductDetail(Long itemInventoryId) {
		ItemInventory inventory=itemInventoryDao.findById(itemInventoryId);
		Product product=new Product();
		product.setProductName(inventory.getItem().getItemName());
		product.setProductDescription(inventory.getItem().getItemDescription());
		product.setProductPrice(WebPosUtility.formatNumber(inventory.getUnitPrice()));
		product.setProductImageUrl(inventory.getImage().getImageKey());
		product.setInventoryId(inventory.getItemInventoryId());
		return product;
	}

}
