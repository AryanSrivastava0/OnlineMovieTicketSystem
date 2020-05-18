package com.capgemini.OTMS.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.OTMS.dao.UserDao;
import com.capgemini.OTMS.entity.User;
import com.capgemini.OTMS.exception.UserException;
import com.capgemini.OTMS.exception.UserNotFoundException;

/****************************
 *          @author          Aryan Srivastava
 *          Description      It is a service implementation class that provide bussiness logic for registerNewUser, 
 *                           signIn & signOut methods for performing operation. 
 *          Version          1.0
 *          Created Date     11-MAY-2020
 ****************************/
@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	public UserDao userDao;
	
	/****************************
	 *    Method        registerNewUser
     *    Description   To implement the method which register the new user & add details to database
     *    Created By    Aryan Srivastava
     *    Created Date  12-MAY-2020                       
	 ****************************/
	@Override
	public Boolean registerNewUser(User user) {
		User Result = userDao.save(user);
		if (Result != null) {
			return true;
		} else
			return false;
	}

	
	/****************************
	 *    Method        signIn
     *    Description   To implement the method which login the user after validating username 
     *                  & password from the database
     *    Created By    Aryan Srivastava
     *    Created Date  12-MAY-2020                       
	 ****************************/
	@Override
	public User signIn(String userName, String password) throws UserNotFoundException {
		
		
		if(userDao.validate(userName, password)!=null)
		{
			return userDao.validate(userName, password); 
		}
		else
		{
			 throw new UserNotFoundException("Wrong Credentials");
		}
	}

	/*
	 * @Override public Boolean signIn(String userName, String password) { return
	 * null; }
	 */

	@Override
	public Boolean signOut() {
		// TODO Auto-generated method stub
		return null;
	}

}
