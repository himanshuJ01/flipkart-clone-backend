package com.flipkartclone.customer.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.flipkartclone.customer.exception.CustomerAlreadyExistException;
import com.flipkartclone.customer.model.Customer;
import com.flipkartclone.customer.repository.CustomerRepository;
import org.mockito.junit.jupiter.MockitoExtension;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {
    @Mock
	private CustomerRepository cr;
    
    @InjectMocks
	private CustomerServiceImpl csl;
	
	
	@Test
	public void TestAddCustomer() throws CustomerAlreadyExistException{
		Customer c1 = new Customer(201, "Tom Shaw", "tom.shaw@xyz.com", (long) 1234567890, "Male", "TTSS@xy", null); //user input
	    when(cr.save(any())).thenReturn(c1);
	    csl.addNewCustomer(c1);
	    verify(cr, times(1)).save(any());
	    
	
	}

}
