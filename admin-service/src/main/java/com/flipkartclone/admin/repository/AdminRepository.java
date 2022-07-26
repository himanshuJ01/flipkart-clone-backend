package com.flipkartclone.admin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.flipkartclone.admin.model.Admin;

public interface AdminRepository extends MongoRepository<Admin, Integer> {

	Admin findByEmail(String email);
}
