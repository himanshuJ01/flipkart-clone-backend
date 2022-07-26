package com.flipkartclone.products.service;

import java.util.List;
import java.util.Optional;

import com.flipkartclone.products.exception.ProductAlreadyExistException;
import com.flipkartclone.products.model.Product;

public interface ProductService {
	
	public Product addNewProduct(Product pro) throws ProductAlreadyExistException;

	public List<Product> getAllProducts();

	public Optional<Product> getByProductId(int proId);

	public void deleteProductByProductId(int proId);


}
