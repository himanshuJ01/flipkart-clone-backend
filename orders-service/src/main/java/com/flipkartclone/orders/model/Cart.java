package com.flipkartclone.orders.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="cartDetails")
public class Cart {
	//private variables
	@Id
	private long cartId;
	private int userId;
	private int productId;
	
	
	//default constructor
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	//parameterize constructor 
	public Cart(long cartId, int userId, int productId) {
		super();
		this.cartId = cartId;
		this.userId = userId;
		this.productId = productId;
	}
	
	//getter and setter
	public long getCartId() {
		return cartId;
	}
	public void setCartId(long cartId) {
		this.cartId = cartId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	//toString method
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", customerId=" + userId + ", productId=" + productId + "]";
	}
	
	
	

}
