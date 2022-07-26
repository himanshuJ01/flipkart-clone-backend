package com.flipkartclone.orders.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flipkartclone.orders.feignclient.ProductClient;
import com.flipkartclone.orders.model.Cart;
import com.flipkartclone.orders.model.Items;
import com.flipkartclone.orders.model.Payment;
import com.flipkartclone.orders.model.Product;
import com.flipkartclone.orders.repository.CartRepository;
import com.flipkartclone.orders.repository.PaymentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private ProductClient productClient;

    @Autowired
    private CartRepository cartRepo;
    
    @Autowired
    private PaymentRepository payRepo;

    //add cart in database
	@Override
	public void addItemTOCart(Cart cart) {
		cartRepo.save(cart);
		
	}

	//delete cart
	@Override
	public void removeItemFromCart(Cart cart) {
		cartRepo.delete(cart);
		
	}

	//get all details of cart and its items
	@Override
	public Items displayAllProductsInCart(int userId) {
		Items items =new Items();
	    items.setCustomerId(userId);
		
		//calls the findByuserId in cart Repository class i,e array list is created 
		ArrayList<Cart> cartList = cartRepo.findByuserId(userId);
		ArrayList<Product> productList=new ArrayList<Product>();
		//to iterate over array list, used to get details of all the product details from cart
		for(int i=0;i<cartList.size();i++)
		{
			//getting productID of the object and passing product id into productClient
			Product product =productClient.getProductById(cartList.get(i).getProductId());
			items.setSubTotal(product.getPrice());
			productList.add(product);
			
		}
		
		items.setList(productList);
	
		return items;
	}
 
	
	//getting  payment  details on console
	@Override
	public Payment newPayment(int cartId) {
		
		Payment payment =new Payment();
	    payment.setCartId(cartId);
		
		//calls the findByuserId in cart Repository class i,e array list is created 
		ArrayList<Cart> cartList = cartRepo.findBycartId(cartId);
		//to iterate over array list, used to get details of all the product details from cart
		for(int i=0;i<cartList.size();i++)
		{
			//getting productID of the object and passing product id into productClient
			Product product =productClient.getProductById(cartList.get(i).getProductId());
	        payment.setSubTotal(product.getPrice());
			payment.setProductId(product.getProductId());
			payment.setPaymentStatus(paymentProcessing());
	        payment.setTransactionId(UUID.randomUUID().toString());
			
		}
		
		
	
		return payRepo.save(payment);
	}
	
	public String paymentProcessing() {
		//api should be third party gateway....
		
		return new Random().nextBoolean()?"success":"false";
	}

     //get all carts 
	@Override
	public List<Cart> getAllCarts() {
	
		return (List<Cart>) cartRepo.findAll();
	}

	@Override
	public Optional<Payment> getByPaymentId(int cartId) {
		return (Optional<Payment>) payRepo.findById(cartId);
	}


	

}
