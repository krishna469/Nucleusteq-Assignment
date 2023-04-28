package com.krishna.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.krishna.dto.LoginDto;
import com.krishna.dto.RegistrationDto;
import com.krishna.entity.Registration;
import com.krishna.exception.DuplicateEmailException;
import com.krishna.exception.DuplicateMobileNumberException;
import com.krishna.exception.UserEmailDomainException;
import com.krishna.exception.UserNotFoundException;
import com.krishna.repo.RegistrationRepo;
import com.krishna.response.LoginResponse;
import com.krishna.service.RegistrationService;

@Service
public class RegistrationImpl implements RegistrationService {

	@Autowired
	private RegistrationRepo registrationRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public String addUser(RegistrationDto registrationDto) throws DuplicateMobileNumberException, DuplicateEmailException, UserEmailDomainException {

		final String EMAIL_DOMAIN = "costacloud.com";

		 if (!registrationDto.getEmail().endsWith("@" + EMAIL_DOMAIN)) {
	            throw new UserEmailDomainException("Email domain should be " + EMAIL_DOMAIN);
	     }
		
		 Optional<Registration> existingUserByMobile = registrationRepo.findByMobile(registrationDto.getMobile());
		 if (existingUserByMobile.isPresent()) {
			 throw new DuplicateMobileNumberException("Mobile number already exists");
		 }
		 
		 Optional<Registration> existingUserByEmail = registrationRepo.findByEmail(registrationDto.getEmail());
		 if (existingUserByEmail.isPresent()) {
			 throw new DuplicateEmailException("Email address already exists");
		 }
		   
	        
		 Registration registration = new Registration(

			registrationDto.getUserName(),registrationDto.getGender(), registrationDto.getRole(), registrationDto.getDept(),
			registrationDto.getEmail(), this.passwordEncoder.encode(registrationDto.getPassword()),
			registrationDto.getMobile()
		);

		try {
			registrationRepo.save(registration);
			
		}catch (Exception e) {
			
			throw e;
			
		}		
		return registration.getUserName()+" Registered Successfully";
	}
	
	
	
	
	

	@Override
	public LoginResponse loginUser(LoginDto loginDto) {

		String msg = "";
		Registration user1 = registrationRepo.getByEmail(loginDto.getEmail());

		if (user1 != null) {

			String password = loginDto.getPassword();
			String encodePassword = user1.getPassword();

			boolean isRightPassword = passwordEncoder.matches(password, encodePassword);

			if (isRightPassword) {

				Optional<Registration> user = registrationRepo.findByEmailAndPassword(loginDto.getEmail(),
						encodePassword);

				if (user.isPresent()) {
					msg = "Login Successfully";
					boolean status = true;
					return new LoginResponse(msg, status);
				} else {

					msg = "Login Faild";
					boolean status = false;
					return new LoginResponse(msg, status);
				}
			} else {
				msg = "Password Not Match";
				boolean status = false;
				return new LoginResponse(msg, status);
			}

		} else {
			msg = "Email not Exists";
			boolean status = false;
			return new LoginResponse(msg, status);
		}

	}
	
	
	


	 @Override
	 public String updateUser(int id, RegistrationDto registrationDto) throws UserNotFoundException {
	     Optional<Registration> optionalUser = registrationRepo.findById(id);
	     if (optionalUser.isPresent()) {
	         Registration user = optionalUser.get();
	         user.setUserName(registrationDto.getUserName());
	         user.setEmail(registrationDto.getEmail());
	         user.setPassword(this.passwordEncoder.encode(registrationDto.getPassword()));
	         registrationRepo.save(user);
	         return registrationDto.getUserName()+" Updated successfully";
	     } else {
	         throw new UserNotFoundException("User not found with id " + id);
	     }
	 }

	 	 
	 @Override
	 public Registration findById(int id) throws UserNotFoundException {
	     Optional<Registration> userOptional = registrationRepo.findById(id);
	     if (userOptional.isPresent()) {
	         return userOptional.get();
	     } else {
	         throw new UserNotFoundException("User with id " + id + " not found");
	     }
	 }

	 
	 
	
	 @Override
		public List<Registration> getAllUsers() {
			return registrationRepo.findAll();
		}
	 
	 @Override
	    public void deleteUserById(int id) {
		 registrationRepo.deleteById(id);
	    }
		

	 
}
