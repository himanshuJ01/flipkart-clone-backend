package com.flipkartclone.orders.model;


import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="paymentDetails")
public class Payment {
	//private variables
	@Id
	private int cartId;
	private BigDecimal subTotal;
	private String transactionId;
	private int productId;
	
	private String paymentStatus;
	
	//default constructor
	public Payment() { 
		super();
		
		// TODO Auto-generated constructor stub
	}
	
	//parameterize constructor
	public Payment( BigDecimal subTotal, String transactionId, int productId, int cartId,
			String paymentStatus) {
		super();
		this.subTotal = subTotal;
		this.transactionId = transactionId;
		this.productId = productId;
		this.cartId = cartId;
		this.paymentStatus = paymentStatus;
	}
	
	//getter and setter
	
	public BigDecimal getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	
	//toString method
	@Override
	public String toString() {
		return "Payment [ subTotal=" + subTotal + ", transactionId=" + transactionId
				+ ", productId=" + productId + ", cartId=" + cartId + ", paymentStatus=" + paymentStatus + "]";
	}
	
	
	

}
