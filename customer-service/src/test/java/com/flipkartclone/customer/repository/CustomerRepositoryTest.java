package com.flipkartclone.customer.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.flipkartclone.customer.model.Customer;

@SpringBootTest
@ExtendWith(SpringExtension.class)

class CustomerRepositoryTest {
	@Autowired
	private CustomerRepository ctmRepo;
	

	@Test
	public void givenCustomerShouldReturnObject() {
		Customer c1 = new Customer(201, "Tom Shaw", "tom.shaw@xyz.com", (long) 1234567890, "Male", "TTSS@xy", null);
		ctmRepo.save(c1); //Data is saved into Database
		Customer c2 = ctmRepo.findById(c1.getCustomerId()).get();
		assertNotNull(c2); //To check if it is returning object
		assertEquals(c1.getFullName(), c2.getFullName());
	}

	@Test
	public void getAllmustAllCustomers() {
		Customer c3 = new Customer(202, "Tom Shaw", "tom.shaw@xyz.com",  (long) 1234567890, "Male", "TTSS@xy", null); //user input
		Customer c4 = new Customer(203, "Tomy Shaw", "tom.shaw@xyz.com", (long) 1234567890, "Male", "TTSS@xy", null); //user input
        ctmRepo.save(c3);  //saving data in database
        ctmRepo.save(c4); //saving data in database
        List<Customer> customerList = (List<Customer>) ctmRepo.findAll();
        assertEquals("Tom Shaw" , customerList.get(0).getFullName());
        assertEquals(3,customerList.size());
	}
	
}
