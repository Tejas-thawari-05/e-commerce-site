package com.ecom.service;

import java.util.List;

import com.ecom.model.Cart;

public interface CartService {

	public Cart saveCart(int productId,int userId);
	
	public List<Cart> getCartByUser(int userId);
}