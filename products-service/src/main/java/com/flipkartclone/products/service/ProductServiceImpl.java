package com.flipkartclone.products.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.flipkartclone.products.exception.ProductAlreadyExistException;
import com.flipkartclone.products.model.Product;
import com.flipkartclone.products.repository.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository prorepo;
	
	
		
//implement service method for add new product in database
	@Override
	public Product addNewProduct(Product pro) throws ProductAlreadyExistException {
		
		if(prorepo.existsById(pro.getProductId())) {
			//throw new ProductAlreadyExistException();
		}

		Product saveCutomer = prorepo.save(pro);
		return saveCutomer;
	}

	//implement service method for getting all product in database
	@Override
	public List<Product> getAllProducts() {
		return (List<Product>) prorepo.findAll();
	}

	//implement service method for get product from product id in database
	@Override
	public Optional<Product> getByProductId(int proId) {
		return (Optional<Product>) prorepo.findById(proId);
	}

	
	//implement service method for delete product from database
	@Override
	public void deleteProductByProductId(int proId) {
		prorepo.deleteById(proId);
		
	}

	

	

}
