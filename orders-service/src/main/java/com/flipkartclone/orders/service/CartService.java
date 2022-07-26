package com.flipkartclone.orders.service;



import java.util.List;
import java.util.Optional;

import com.flipkartclone.orders.model.Cart;
import com.flipkartclone.orders.model.Items;
import com.flipkartclone.orders.model.Payment;

public interface CartService {

	public void addItemTOCart(Cart cart);
	public void removeItemFromCart(Cart cart);
	public Items displayAllProductsInCart(int customerId);
	public Payment newPayment(int cartId);
	List<Cart> getAllCarts();
	public Optional<Payment> getByPaymentId(int cartId);
    
}
