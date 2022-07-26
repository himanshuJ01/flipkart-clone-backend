package com.flipkartclone.products.controller;


import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flipkartclone.products.model.Product;
import com.flipkartclone.products.service.ProductService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;



@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

	@Autowired
	private MockMvc mocMvc;
	
	@Mock
	private  ProductService productService;
	private  Product product;
	private List< Product> productList;
	
	@InjectMocks
	private  ProductController productController;
	
	@BeforeEach
	public void setUp() {
		product = new  Product(101, "Fashion","T-Shirt","Clothes","Null",200.0,"Null","Null",200.0);
		mocMvc= MockMvcBuilders.standaloneSetup(productController).build();
	}
	
	
	@Test
	public void ProductControllerTest() throws Exception{
		when(productService.addNewProduct(any())).thenReturn(product);
		mocMvc.perform(post("/addproduct")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJSONString(product)))
		        .andExpect(status().isCreated());
    	verify(productService,times(1)).addNewProduct(any());

	}
	
	 @Test
	    public void getAllProductControllerTest() throws Exception {
	    	when(productService.getAllProducts()).thenReturn(productList);
	    	mocMvc.perform(MockMvcRequestBuilders.get("/allproducts")
	    	.contentType(MediaType.APPLICATION_JSON)
	    	.content(asJSONString(product)))
	    	.andDo(MockMvcResultHandlers.print());
	    	verify(productService,times(1)).getAllProducts();
	    	
	    	
	    }


	public static String asJSONString(final Object obj) {
		// TODO Auto-generated method stub
		try {
			
		return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


	

}
