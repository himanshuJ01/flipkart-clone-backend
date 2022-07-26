package com.flipkartclone.admin.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.flipkartclone.admin.model.Admin;

@SpringBootTest
@ExtendWith(SpringExtension.class)

class AdminRepositoryTest {
	@Autowired
	private AdminRepository adminRepo;
	

	@Test
	public void givenAdminShouldReturnObject() {
		Admin a1 = new Admin(201, "tom.shaw@xyz.com", "TTSS@xy"); //user input
		adminRepo.save(a1); //Data is saved into Database
		Admin a2 = adminRepo.findById(a1.getAdminId()).get();
		assertNotNull(a2); //To check if it is returning object
		assertEquals(a1.getEmail(), a2.getEmail());
	}

	@Test
	public void getAllmustAllCustomers() {
		Admin a3 = new Admin(202, "tom.shaw@xyz.com", "TTSS@xy"); //user input
		Admin a4 = new Admin(203, "tom.shaw@xyz.com","TTSS@xy"); //user input
        adminRepo.save(a3);  //saving data in database
        adminRepo.save(a4); //saving data in database
        List<Admin> adminList = (List<Admin>) adminRepo.findAll();
        assertEquals("tom.shaw@xyz.com" , adminList.get(1).getEmail());
        assertEquals(4,adminList.size());
	}
	
}
