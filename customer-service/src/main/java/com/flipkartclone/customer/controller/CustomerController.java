package com.flipkartclone.customer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flipkartclone.customer.exception.CustomerAlreadyExistException;
import com.flipkartclone.customer.model.Customer;
import com.flipkartclone.customer.model.JwtResponse;
import com.flipkartclone.customer.service.CustomerService;
import com.flipkartclone.customer.service.UserService;
import com.flipkartclone.customer.util.JwtUtil;

@RestController
@CrossOrigin(origins="*")

@RequestMapping("/")

public class CustomerController {
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserService userService;
	
    @Autowired
	private CustomerService ctmserv;
	
	
    
    @PostMapping("/customer-auth")
	public JwtResponse authenticate(@RequestBody Customer customerRequest) throws Exception{
		try {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						customerRequest.getEmail(), customerRequest.getPassword()));
		}
		catch(BadCredentialsException e) {
			throw new Exception("Invalid_Credentials",e);
		}
		final UserDetails userDetails
			= userService.loadUserByUsername(customerRequest.getEmail());
		
		final String token=
				jwtUtil.generateToken(userDetails);
		
		return new JwtResponse(token);
	}
	
	
	
	@PostMapping("/add")
	public ResponseEntity<Customer> addNewCustomer(@RequestBody Customer ctm ) throws CustomerAlreadyExistException{
		
		Customer savedCustomer = ctmserv.addNewCustomer(ctm);
		return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
	}
	
	
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomers(){
		return new ResponseEntity<List<Customer>>((List<Customer>)ctmserv.getAllCustomers(), HttpStatus.OK);
	}
	
	@DeleteMapping("/del/{customerId}")
	public ResponseEntity<Void> deleteCustomerById(@PathVariable int customerId){
    ctmserv.deleteCustomerByCustomerId(customerId);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("find/{customerId}")	
	public ResponseEntity<Optional<Customer>> getCustomerById(@PathVariable int customerId)  {
		return new ResponseEntity<Optional<Customer>>((Optional<Customer>)ctmserv.getByCustomerId(customerId), HttpStatus.OK);

}
	
	
}
