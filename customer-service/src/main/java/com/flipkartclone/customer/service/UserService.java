package com.flipkartclone.customer.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.flipkartclone.customer.model.Customer;
import com.flipkartclone.customer.repository.CustomerRepository;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Customer foundCustomer = customerRepository.findByEmail(email);
		if(foundCustomer == null)
			return null;
		String email1 = foundCustomer.getEmail();
		String password  = foundCustomer.getPassword();
		return new User(email1, password,new ArrayList<>());
	}

}
