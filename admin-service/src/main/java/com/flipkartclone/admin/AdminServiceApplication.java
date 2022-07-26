package com.flipkartclone.admin;

import java.util.stream.Collectors;
import java.util.List;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.flipkartclone.admin.model.Admin;
import com.flipkartclone.admin.repository.AdminRepository;

@SuppressWarnings("deprecation")
@SpringBootApplication
@EnableEurekaClient
public class AdminServiceApplication {
	
	@Autowired
	private AdminRepository adminReprository;
	
	
	@PostConstruct
	public void initAdmin() {
		List<Admin> admins = Stream.of(
				new Admin(123, "admin@xyx.com", "admin@xy")
				
		).collect(Collectors.toList());	
		adminReprository.saveAll(admins);
	}
	

	public static void main(String[] args) {
		SpringApplication.run(AdminServiceApplication.class, args);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}
