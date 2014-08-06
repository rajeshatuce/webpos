package com.dazzlersoft.webpos.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dazzlersoft.webpos.model.Category;
import com.dazzlersoft.webpos.model.Product;
import com.dazzlersoft.webpos.model.ProductPriceDto;
import com.dazzlersoft.webpos.service.WebPosService;

@Controller
public class HomeController {
	private static final String MYCART = "mycart";
	private static final String MYCARTCOUNT = "mycartcount";
	private static final Log LOG = LogFactory.getLog(HomeController.class);
	@Autowired
	private WebPosService webPosService;

	@RequestMapping("/home")
	public String invokeHomeController(@RequestParam(required=false) Long categoryId,HttpServletRequest request,final Map<String, Object> map) {
		List<Category> result = findListOfCategories(categoryId);
		map.put("categoryList", result);
		map.put("productList", webPosService.getProductsForCategory(categoryId));
		map.put(MYCARTCOUNT, getCountOfItemSelectedForPurchase(request));
		return "whatsnew";
	}

	private List<Category> findListOfCategories(Long categoryId) {
		List<Category> categoryList=webPosService.fetchAllCategory();
		List<Category> result=new ArrayList<Category>();
		result.add(getWhatsNewCategory());
		result.addAll(categoryList);
		updateSetSelectOnBasisOfCategory(result, categoryId);
		return result;
	}
	@SuppressWarnings("unchecked")
	private String getCountOfItemSelectedForPurchase(HttpServletRequest request){
		String count="0";
		if(request.getSession().getAttribute(MYCART)!=null){
			List<Long> cart=(List<Long>) request.getSession().getAttribute(MYCART);
			count=cart.size()+"";
		}
		return count;
	}

	@RequestMapping("/getResource")
	public void streamImageForImageId(@RequestParam("imageId")String imageId,HttpServletResponse response){
		LOG.info("Fetching image content for imageId:"+imageId);
		try{
			response.setContentType("image/gif");
			response.getOutputStream().write(webPosService.getImageFromRepository(imageId));
			response.getOutputStream().flush();
		}catch(Exception err){
			LOG.error("Error occurred while fetching image with imageId:"+imageId,err);
		}
	}

	@RequestMapping("/addImage")
	public @ResponseBody String addImage(){
		try {
			webPosService.addImage();
			return "done";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	@RequestMapping("/selectProduct")
	public String selectProduct(@RequestParam("selectedProduct")Long selectedProduct,@RequestParam(required=false) Long categoryId,@RequestParam(required=false) Long addProductToCart,HttpServletRequest request,final Map<String, Object> map){
		LOG.info("Selected Product:"+selectedProduct);
		List<Category> result = findListOfCategories(categoryId);
		map.put("categoryList", result);
		if(addProductToCart!=null && addProductToCart==1){
			addproductToCart(selectedProduct, request);
		}else if(addProductToCart!=null && addProductToCart==0){
			removeProductFromCart(selectedProduct, request);

		}
		map.put(MYCARTCOUNT, getCountOfItemSelectedForPurchase(request));
		map.put("isSelectedProductAddedToCart", isSelectedProductAlreadyAddedToCart(selectedProduct, request));
		map.put("product", webPosService.getSelectedProductDetail(selectedProduct));

		return "productDescription";
	}
	
	@RequestMapping("/myCart")
	public  @ResponseBody ProductPriceDto showMyCart(HttpServletRequest request,final Map<String, Object> map){
		ProductPriceDto result=null;
		if(request.getSession().getAttribute(MYCART)!=null){
			List<Long> inventoryList=(List<Long>) request.getSession().getAttribute(MYCART);
			result=webPosService.getMyCartContent(inventoryList);
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	private void addproductToCart(Long selectedProduct,HttpServletRequest request){
		List<Long> selectedProductList=null;
		if(request.getSession().getAttribute(MYCART)!=null){
			selectedProductList=(List<Long>) request.getSession().getAttribute(MYCART);
		}else{
			selectedProductList=new ArrayList<Long>();
			request.getSession().setAttribute(MYCART, selectedProductList);
		}
		if(!selectedProductList.contains(selectedProduct)){
			selectedProductList.add(selectedProduct);
		}
		
	}
	@SuppressWarnings("unchecked")
	private void removeProductFromCart(Long selectedProduct,HttpServletRequest request){
		if(request.getSession().getAttribute(MYCART)!=null){
			List<Long> selectedProductList=(List<Long>) request.getSession().getAttribute(MYCART);
			selectedProductList.remove(selectedProduct);
		}
	}
	@SuppressWarnings("unchecked")
	private boolean isSelectedProductAlreadyAddedToCart(Long selectedProduct,HttpServletRequest request){
		List<Long> selectedProductList=null;
		if(request.getSession().getAttribute(MYCART)!=null){
			selectedProductList=(List<Long>) request.getSession().getAttribute(MYCART);
			if(selectedProductList.contains(selectedProduct)){
				return true;
			}
		}
		return false;
	}
	private Category getWhatsNewCategory(){
		Category category=new Category();
		category.setCategoryName("What's New");
		category.setCategoryId(0l);
		return category;
	}

	private void updateSetSelectOnBasisOfCategory(List<Category> result,Long categoryId){
		if(categoryId==null){
			categoryId=0l;//make whats new as selected
		}
		for(Category category:result){
			if(category.getCategoryId()==categoryId){
				category.setSelected("true");
			}else{
				category.setSelected("false");
			}
		}
	}
}
