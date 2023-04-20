package com.krishna.service;

import com.krishna.dto.RegistrationDto;
import com.krishna.entity.Registration;
import com.krishna.entity.Tickets;
import com.krishna.exception.DuplicateEmailException;
import com.krishna.exception.DuplicateMobileNumberException;
import com.krishna.exception.UserEmailDomainException;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.krishna.dto.LoginDto;
import com.krishna.response.LoginResponse;

@Service
public interface RegistrationService {
	
	String addUser(RegistrationDto registrationDto)throws DuplicateMobileNumberException, DuplicateEmailException,SQLIntegrityConstraintViolationException,UserEmailDomainException;

	LoginResponse loginUser(LoginDto loginDto);

	Registration updateUser(int id, RegistrationDto userDto);

//	Registration getUserById(int id);
	List<Registration> getAllUsers();
	
	Registration findById(int id);
	
	void deleteUserById(int id);
}
