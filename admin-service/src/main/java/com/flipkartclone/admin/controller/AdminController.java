package com.flipkartclone.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flipkartclone.admin.model.Admin;
import com.flipkartclone.admin.model.JwtResponse;
import com.flipkartclone.admin.service.AdminService;
import com.flipkartclone.admin.service.UserService;
import com.flipkartclone.admin.util.JwtUtil;

@RestController
@RequestMapping("/")
@CrossOrigin(origins="*")
public class AdminController {
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AdminService adminService;
	
	
	
	@PostMapping("/admin-auth")
	public JwtResponse authenticate(@RequestBody Admin adminRequest) throws Exception{
		try {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						adminRequest.getEmail(), adminRequest.getPassword()));
		}
		catch(BadCredentialsException e) {
			throw new Exception("Invalid_Credentials",e);
		}
		final UserDetails userDetails
			= userService.loadUserByUsername(adminRequest.getEmail());
		
		final String token=
				jwtUtil.generateToken(userDetails);
		
		return new JwtResponse(token);
	}
	
	
	
	
	@GetMapping("/alladmins")
	public ResponseEntity<List<Admin>> getAllAdmins(){ 
		return new ResponseEntity<List<Admin>>((List<Admin>)adminService.getAllAdmins(), HttpStatus.OK);

}
}