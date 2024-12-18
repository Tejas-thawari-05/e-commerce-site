package com.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ecom.model.Category;
import com.ecom.model.Product;
import com.ecom.service.CategoryService;
import com.ecom.service.ProductService;


@Controller
public class HomeController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@GetMapping("/product")
	public String product(Model model) {
		
		List<Category> categories = categoryService.getAllActiveCategory();
		//List<Product> products = productService.getAllActiveProducts();
		model.addAttribute("category",categories);
	//	model.addAttribute("product",products);
		return "product";
	}
	
	@GetMapping("/viewproduct")
	public String viewproduct() {
		return "view_product";
	}
	
}
