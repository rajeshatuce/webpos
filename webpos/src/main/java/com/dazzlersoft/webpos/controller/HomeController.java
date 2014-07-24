package com.dazzlersoft.webpos.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dazzlersoft.webpos.model.Category;
import com.dazzlersoft.webpos.service.WebPosService;

@Controller
public class HomeController {
	private static final Log LOG = LogFactory.getLog(HomeController.class);
	@Autowired
	private WebPosService webPosService;

	@RequestMapping("/home")
    public String invokeHomeController(@RequestParam(required=false) Long categoryId,final Map<String, Object> map) {
		List<Category> categoryList=webPosService.fetchAllCategory();
		List<Category> result=new ArrayList<Category>();
		result.add(getWhatsNewCategory());
		result.addAll(categoryList);
		updateSetSelectOnBasisOfCategory(result, categoryId);
		map.put("categoryList", result);
		map.put("productList", webPosService.getProductsForCategory(categoryId));
        return "whatsnew";
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
