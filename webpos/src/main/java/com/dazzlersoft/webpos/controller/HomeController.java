package com.dazzlersoft.webpos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dazzlersoft.webpos.model.Category;
import com.dazzlersoft.webpos.service.WebPosService;

@Controller
public class HomeController {
	
	@Autowired
	private WebPosService webPosService;

	@RequestMapping("/home")
    public String invokeHomeController() {
		
		List<Category> result=webPosService.fetchAllCategory();
 
        return "whatsnew";
    }
}
