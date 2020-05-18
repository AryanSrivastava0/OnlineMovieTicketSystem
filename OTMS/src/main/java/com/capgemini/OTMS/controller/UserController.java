package com.capgemini.OTMS.controller;

import java.util.List;
import java.util.Optional;

import javax.security.auth.login.AccountNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.OTMS.entity.User;
import com.capgemini.OTMS.service.UserService;
import com.capgemini.OTMS.exception.UserException;
import com.capgemini.OTMS.exception.UserNotFoundException;

/****************************
 *          @author          Aryan Srivastava
 *          Description      It is a controller class typically used in combination 
 *                           with annotated handler methods based on the mapping annotation  
 *          Version          1.0
 *          Created Date     12-MAY-2020
 ****************************/
@RestController
public class UserController {

	@Autowired
	public UserService userService;

	
	/****************************
	 *    Method        registerNewUser
     *    Description   To register the new user & add details to database
     *    @throws UserException- It is raised if i'd present already in the database
     *    Created By    Aryan Srivastava
     *    Created Date  12-MAY-2020                       
	 ****************************/
	@PostMapping(value = "/registration")
	public ResponseEntity<String> registerNewUser(@Valid @RequestBody User user, BindingResult br)
			throws UserException {
		String err = "";
		if (br.hasErrors()) {
			List<FieldError> errors = br.getFieldErrors();
			for (FieldError error : errors)
				err += error.getDefaultMessage() + "<br/>";
			throw new UserException(err);
		}
		try {
			userService.registerNewUser(user);
			return new ResponseEntity<String>("Wow!!Regostration Successful", HttpStatus.OK);

		} catch (DataIntegrityViolationException ex) {
			throw new UserException("ID already exists");
		}
	}
	
	/****************************
	 *    Method        signIn
     *    Description   To login the user after validating username & password from the database
     *    @throws UserNotFoundException- It is raised if i'd not present in the database
     *    Created By    Aryan Srivastava
     *    Created Date  13-MAY-2020                       
	 ****************************/
	@PostMapping(value="/login")
	public ResponseEntity<User> signIn( @RequestBody User user ) throws UserNotFoundException
	{
		User userFound=userService.signIn(user.getUserName(), user.getPassword());
		
		
			return new  ResponseEntity<User>(userFound, HttpStatus.OK);
		
		}
}
