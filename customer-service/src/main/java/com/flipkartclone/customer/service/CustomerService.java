package com.flipkartclone.customer.service;

import java.util.List;
import java.util.Optional;

import com.flipkartclone.customer.exception.CustomerAlreadyExistException;
import com.flipkartclone.customer.model.Customer;
public interface CustomerService {

	public Customer addNewCustomer(Customer ctm) throws CustomerAlreadyExistException;

	public List<Customer> getAllCustomers();

	public Optional<Customer> getByCustomerId(int ctmId);

	public void deleteCustomerByCustomerId(int ctmId);

}
