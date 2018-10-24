package com.ecommerce.photon;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ecommerce.photon.model.User;
import com.ecommerce.photon.repo.UserProfileRepoImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserProfileServiceApplicationTests {
        
    @Autowired
    UserProfileRepoImpl userProfileRepoImpl; 
	
	@Test
	public void userName() {	    
	    try {
	        String email = "mohan@test.com";
	        String password = "mohan@123";
	        User emailPassword = userProfileRepoImpl.findUserByEmail(email, password);
	        System.out.println("emailPassword===================>" + emailPassword);
            assertEquals(email, emailPassword.getEmail());
        } catch (Exception e) {
            e.printStackTrace();
        }
	    
	}

}
