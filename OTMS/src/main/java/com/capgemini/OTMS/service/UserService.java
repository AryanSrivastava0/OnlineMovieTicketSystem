package com.capgemini.OTMS.service;

import java.util.Optional;

import org.springframework.web.bind.annotation.RequestBody;

import com.capgemini.OTMS.entity.User;
import com.capgemini.OTMS.exception.UserNotFoundException;

/****************************
 *          @author          Aryan Srivastava
 *          Description      It is a service interface that provide the methods for adding new customer
 *                           & login user and further implemented by service implementation  
 *          Version          1.0
 *          Created Date     11-MAY-2020
 ****************************/
public interface UserService {
    
	/****************************
	 *    Method        registerNewUser
     *    Description   define the method
     *    Created By    Aryan Srivastava
     *    Created Date  12-MAY-2020                       
	 ****************************/
	Boolean registerNewUser(User user);
    
	/****************************
	 *    Method        signIn
     *    Description   define the method
     *    Created By    Aryan Srivastava
     *    Created Date  12-MAY-2020                       
	 ****************************/
	User signIn(String userName, String password) throws UserNotFoundException;

	//Boolean signIn(String userName, String password);
    
	/****************************
	 *    Method        signOut
     *    Description   define the method
     *    Created By    Aryan Srivastava
     *    Created Date  12-MAY-2020                       
	 ****************************/
	Boolean signOut();

	
}
