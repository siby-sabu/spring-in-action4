package com.spittr.web;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({"/","/homepage"})
public class HomeController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String home() {
		System.out.println("Inside home controller");
		System.out.println(new BCryptPasswordEncoder().encode("pass"));
		return "home";
	}

}
