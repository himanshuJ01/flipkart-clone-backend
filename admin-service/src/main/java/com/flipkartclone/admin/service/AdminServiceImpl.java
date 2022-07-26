package com.flipkartclone.admin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.flipkartclone.admin.model.Admin;
import com.flipkartclone.admin.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService, UserDetailsService {

	List<Admin> list;
	
	private AdminRepository adminRepository;

	@Autowired
	public AdminServiceImpl(AdminRepository adminRepository ) {
		super();
		this.adminRepository = adminRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Admin foundCustomer = adminRepository.findByEmail(email);
		if(foundCustomer == null)
			return null;
		String email1 = foundCustomer.getEmail();
		String password  = foundCustomer.getPassword();
		
		return new User(email1, password, new ArrayList<>());
	}

	@Override
	public List<Admin> getAllAdmins() {
		
		return (List<Admin>) adminRepository.findAll();
	}
   
	

	public void addNewAdmin(Admin a1) {
		// TODO Auto-generated method stub
		
	}

}
