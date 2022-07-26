package com.flipkartclone.customer.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.flipkartclone.customer.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, Integer> {

	Customer findByEmail(String email);

	

	

	
}
