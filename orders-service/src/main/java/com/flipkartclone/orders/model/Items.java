package com.flipkartclone.orders.model;



import java.math.BigDecimal;
import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
 
@Document(collection="items")
public class Items {
	//private variables
	 @Transient
	    public static final String SEQUENCE_NAME = "item_sequence";
	@Id
	private int itemId;
	private int customerId;
	private ArrayList<Product> list;
	private int quantity;
	private BigDecimal subTotal;

	
	//default constructor
	public Items() {
		super();
		// TODO Auto-generated constructor stub
	}

	//parameterize constructor 
	public Items(int itemId, int customerId, ArrayList<Product> list, int quantity, BigDecimal subTotal) {
		super();
		this.itemId = itemId;
		this.customerId = customerId;
		this.list = list;
		this.quantity = quantity;
		this.subTotal = subTotal;
	}

	//getter and setter
	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public ArrayList<Product> getList() {
		return list;
	}

	public void setList(ArrayList<Product> list) {
		this.list = list;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}

	
	//toString method
	@Override
	public String toString() {
		return "Items [itemId=" + itemId + ", customerId=" + customerId + ", list=" + list + ", quantity=" + quantity
				+ ", subTotal=" + subTotal + "]";
	}

				
}
