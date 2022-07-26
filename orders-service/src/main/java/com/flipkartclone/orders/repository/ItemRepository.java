package com.flipkartclone.orders.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.flipkartclone.orders.model.Items;

public interface ItemRepository extends MongoRepository<Items, Integer > {

}
