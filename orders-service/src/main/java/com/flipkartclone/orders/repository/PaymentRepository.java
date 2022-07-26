package com.flipkartclone.orders.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.flipkartclone.orders.model.Payment;


public interface PaymentRepository extends MongoRepository<Payment, Integer> {
	
	

}
