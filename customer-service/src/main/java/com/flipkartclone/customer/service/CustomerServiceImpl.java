package com.flipkartclone.customer.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flipkartclone.customer.exception.CustomerAlreadyExistException;
import com.flipkartclone.customer.model.Customer;
import com.flipkartclone.customer.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	
	private CustomerRepository ctmrepo;
	


	@Autowired
	public CustomerServiceImpl(CustomerRepository ctmrepo) {
		super();
		this.ctmrepo = ctmrepo;
	}
//adding new customer in database
	@Override
	public Customer addNewCustomer(Customer ctm) throws CustomerAlreadyExistException {
		
		if(ctmrepo.existsById(ctm.getCustomerId())) {
			throw new CustomerAlreadyExistException();
		}

		Customer saveCutomer = ctmrepo.save(ctm);
		return saveCutomer;
	}

	//getting all customer from database
	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return (List<Customer>) ctmrepo.findAll();
	}
  
	
	//get customer by id
	@Override
	public Optional<Customer> getByCustomerId(int ctmId) {
		return (Optional<Customer>) ctmrepo.findById(ctmId);
	}

	//delete customer by id
	@Override
	public void deleteCustomerByCustomerId(int ctmId) {
		// TODO Auto-generated method stub
		ctmrepo.deleteById(ctmId);
	}

}
