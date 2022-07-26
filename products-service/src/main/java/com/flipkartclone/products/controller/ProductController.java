package com.flipkartclone.products.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flipkartclone.products.exception.ProductAlreadyExistException;
import com.flipkartclone.products.model.Product;
import com.flipkartclone.products.service.ProductService;


@RestController
@CrossOrigin("*")
@RequestMapping("/")

public class ProductController {

	
	    @Autowired
		private ProductService proserv;
		
		// adding product to database
		@PostMapping("/addproduct")
		public ResponseEntity<Product> addNewProduct(@RequestBody Product pro ) throws ProductAlreadyExistException{
			
			Product savedProduct = proserv.addNewProduct(pro);
			return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
		}
		
		
		// show all products
		@GetMapping("/allproducts")
		public ResponseEntity<List<Product>> getAllProducts(){
			return new ResponseEntity<List<Product>>((List<Product>)proserv.getAllProducts(), HttpStatus.OK);
		}
		
		
		//delete product by product id
		@DeleteMapping("/del/{productId}")
		public ResponseEntity<Void> deleteProductByProductId(@PathVariable int productId){
	    proserv.deleteProductByProductId(productId);
			return ResponseEntity.noContent().build();
		}
		
		
		//get product by product id
		@GetMapping("/find/{productId}")
		public ResponseEntity<Optional<Product>> getProductByProductId(@PathVariable int productId){
	    return new ResponseEntity<Optional<Product>>((Optional<Product>)proserv.getByProductId(productId), HttpStatus.OK);
		}
		
		
		
	
}
