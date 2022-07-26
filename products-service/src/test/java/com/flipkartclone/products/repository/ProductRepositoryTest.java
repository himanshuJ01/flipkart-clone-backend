package com.flipkartclone.products.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.flipkartclone.products.model.Product;

@SpringBootTest
@ExtendWith(SpringExtension.class)

class ProductRepositoryTest {
	@Autowired
	private ProductRepository proRepo;
	

	@Test
	public void givenProductShouldReturnObject() {
		Product c1 = new Product(201, "Fashion", "Cotton Shirt White", "Clothes", "Null", 203,"Null","Null",0.0);
		proRepo.save(c1); //Data is saved into Database
		Product c2 = proRepo.findById(c1.getProductId()).get();
		assertNotNull(c2); //To check if it is returning object
		assertEquals(c1.getProductName(), c2.getProductName());
	}

	@Test
	public void getAllmustAllProducts() {
		Product c3 = new Product(206, "Fashion", "Cotton Shirt White", "Clothes", "Null", 203,"Null","Null",0.0); //user input
		Product c4 = new Product(205, "Fashion", "Cotton Shirt White", "Clothes", "Null", 203,"Null","Null",0.0); //user input
        proRepo.save(c3);  //saving data in database
        proRepo.save(c4); //saving data in database
        List<Product> productList = (List<Product>) proRepo.findAll();
        //assertEquals("Cotton Shirt White" , productList.get(1).getProductName());
        assertEquals(10,productList.size());
	}

}
