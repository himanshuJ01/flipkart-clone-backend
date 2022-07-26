package com.flipkartclone.orders.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flipkartclone.orders.model.Cart;
import com.flipkartclone.orders.model.Items;
import com.flipkartclone.orders.model.Payment;
import com.flipkartclone.orders.service.CartService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/")

public class CartController {

	@Autowired
	CartService  cartService;
	
	// add items to cart
	@PostMapping("/cart-add")
	public void addToCart(@RequestBody Cart cart)
	{
		cartService.addItemTOCart(cart);
}
	// delete items from cart
	@DeleteMapping("/cart-remove")
	public void removeFromCart(@RequestBody Cart cart)
	{
	     cartService.removeItemFromCart(cart);
	}
	
	// display products in a cart for particular customer
	@GetMapping("/cart-show/{userId}")
	public Items showItems(@PathVariable int userId) {
		
		return cartService.displayAllProductsInCart(userId);
	}
	
	
	//done payment
	@GetMapping("/payment/{cartId}")
	public Payment newPayment(@PathVariable int cartId) {
		return cartService.newPayment(cartId);
	}
	
	
	
	//display all carts
	
	@GetMapping("/cart-all")
	public ResponseEntity<List<Cart>> getAllCarts(){
		return new ResponseEntity<List<Cart>>((List<Cart>)cartService.getAllCarts(), HttpStatus.OK);
	}
	
	
	
	}