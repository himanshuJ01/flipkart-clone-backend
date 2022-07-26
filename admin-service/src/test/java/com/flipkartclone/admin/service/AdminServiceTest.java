package com.flipkartclone.admin.service;



import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.junit.jupiter.MockitoExtension;

import com.flipkartclone.admin.model.Admin;
import com.flipkartclone.admin.repository.AdminRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class AdminServiceTest {
//    @Mock
//	private AdminRepository ar;
//    
//    @InjectMocks
//	private AdminServiceImpl asl;
//	
//	
//	@Test
//	public void TestAddAdmin(){
//		Admin a1 = new Admin(201, "Tom Shaw", "TTSS@xy"); //user input
//	    when(ar.save(any())).thenReturn(a1);
//	    asl.addNewAdmin(a1);
//	    verify(ar, times(1)).save(any());
//	    
//	}
}