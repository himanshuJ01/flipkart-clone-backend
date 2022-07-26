package com.flipkartclone.admin.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.flipkartclone.admin.model.Admin;
import com.flipkartclone.admin.repository.AdminRepository;


@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Admin foundCustomer = adminRepository.findByEmail(email);
		if(foundCustomer == null)
			return null;
		String email2 = foundCustomer.getEmail();
		String password1  = foundCustomer.getPassword();
		return new User(email2, password1,new ArrayList<>());
	}

}
