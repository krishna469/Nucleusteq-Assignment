package com.krishna.controller;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krishna.dto.LoginDto;
import com.krishna.dto.RegistrationDto;
import com.krishna.entity.Registration;
import com.krishna.exception.DuplicateEmailException;
import com.krishna.exception.DuplicateMobileNumberException;
import com.krishna.exception.UserEmailDomainException;
import com.krishna.response.LoginResponse;
import com.krishna.service.RegistrationService;

@RestController
@CrossOrigin
@RequestMapping("/api/users")

public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;

	@PostMapping(path = "/save")
	public String saveUser(@RequestBody RegistrationDto registrationDto)
			throws DuplicateMobileNumberException, DuplicateEmailException, SQLIntegrityConstraintViolationException,UserEmailDomainException {

		String id = registrationService.addUser(registrationDto);
		return id;

	}

//	@ExceptionHandler(DuplicateMobileNumberException.class)
//	public ResponseEntity<String> handleDuplicateUsernameException(DuplicateMobileNumberException e) {
//		return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//	}
//
//	@ExceptionHandler(DuplicateEmailException.class)
//	public ResponseEntity<String> handleDuplicateEmailException(DuplicateEmailException e) {
//		return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//	}
//
//	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
//	public ResponseEntity<String> handleSQLIntegrityConstraintViolationException(
//			SQLIntegrityConstraintViolationException e) {
//		return new ResponseEntity<>("Duplicate value for a unique field found in the request.", HttpStatus.BAD_REQUEST);
//	}

	@PostMapping(path = "/login")
	public ResponseEntity<?> loginUser(@RequestBody LoginDto loginDto) {

		LoginResponse loginResponse = registrationService.loginUser(loginDto);
		return ResponseEntity.ok(loginResponse);

	}

	@PutMapping("/update/{id}")
	public Registration updateUser(@PathVariable int id, @RequestBody RegistrationDto userDto) {
		return registrationService.updateUser(id, userDto);
	}

	@GetMapping("/{id}")
	public Registration findById(@PathVariable int id) {
		return registrationService.findById(id);
	}

	@GetMapping
	public List<Registration> getAllUsers() {
		return registrationService.getAllUsers();
	}

	 @DeleteMapping("/delete/{id}")
	    public ResponseEntity<Void> deleteUserById(@PathVariable int id) {
		 registrationService.deleteUserById(id);
	        return ResponseEntity.noContent().build();
	    }
}
