package com.flipkartclone.products.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.flipkartclone.products.exception.ProductAlreadyExistException;
import com.flipkartclone.products.model.Product;
import com.flipkartclone.products.repository.ProductRepository;



@SpringBootTest
@ExtendWith(MockitoExtension.class)

class ProductServiceTest {
	
	@Mock
	 private ProductRepository productRepository;
	 
	 @InjectMocks
	 private ProductServiceImpl productServiceImpl;

	@Test
	public void TestAddNewProduct() throws ProductAlreadyExistException{
	     Product p1 = new  Product(500, "Fashion","T-Shirt","Clothes","Null",200.0,"Null","Null",200.0); //user Input
       when(productRepository.save(any())).thenReturn(p1);
       productServiceImpl.addNewProduct(p1); // Data is saved in Database
       verify(productRepository,times(1)).save(any());
	}
	
	@Test
	public void testgetAllproductss() {
		Product p1 = new  Product(501, "Fashion","T-Shirt","Clothes","Null",200.0,"Null","Null",200.0);//user Input
		Product p2 = new  Product(502, "Fashion","T-Shirt","Clothes","Null",200.0,"Null","Null",200.0); //user Input
		Product p3 = new  Product(503, "Fashion","T-Shirt","Clothes","Null",200.0,"Null","Null",200.0); // user Input
		productRepository.save(p1);
		productRepository.save(p2);
		productRepository.save(p3);
		List<Product>rList = new ArrayList<>(); //  Creating list Object
		rList.add(p1);
		rList.add(p2);
		rList.add(p3);
		
		when(productRepository.findAll()).thenReturn(rList);
		List<Product> rList1 = productServiceImpl.getAllProducts();
		assertEquals(rList, rList1);
		verify(productRepository,times(1)).save(p1);
		verify(productRepository,times(1)).findAll();
		

	}
	
	
	}
	


