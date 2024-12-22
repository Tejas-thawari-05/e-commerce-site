package com.ecom.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecom.model.UserDtls;
import com.ecom.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String home() {
		
		return "user/home";
	}
	
	@ModelAttribute
	public void getUserDetails(Principal principle, Model model) {
		if(principle!=null) {
			String email = principle.getName();
			UserDtls userDtls = userService.getUserByEmail(email);
			model.addAttribute("user", userDtls);
		}
	}
}
