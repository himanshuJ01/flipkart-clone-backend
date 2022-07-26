package com.flipkartclone.orders.repository;

import java.util.ArrayList;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.flipkartclone.orders.model.Cart;

public interface CartRepository extends MongoRepository<Cart, Integer> {
	@SuppressWarnings("unchecked")

	Cart save(Cart cart);
	// deletes customer and product from cart
	void delete(Cart cart);
	// displays products in a cart for particular customer
	ArrayList<Cart> findByuserId(int customerId);
	ArrayList<Cart> findBycartId(int cartId);

	
	
}
