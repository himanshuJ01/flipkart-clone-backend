package com.flipkartclone.products.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.flipkartclone.products.model.Product;

public interface ProductRepository extends MongoRepository<Product, Integer>  {

	//repository interface 

}
