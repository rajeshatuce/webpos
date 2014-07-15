package com.dazzlersoft.webpos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/whatsnew")
    public String helloWorld() {
 
        return "whatsnew";
    }
}
