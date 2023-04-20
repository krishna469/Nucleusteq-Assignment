package com.krishna.service.impl;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.krishna.dto.LoginDto;
import com.krishna.dto.RegistrationDto;
import com.krishna.entity.Registration;
import com.krishna.entity.Tickets;
import com.krishna.exception.DuplicateEmailException;
import com.krishna.exception.DuplicateMobileNumberException;
import com.krishna.exception.UserEmailDomainException;
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
	public String addUser(RegistrationDto registrationDto)
			throws DuplicateMobileNumberException, DuplicateEmailException,SQLIntegrityConstraintViolationException, UserEmailDomainException {



		final String EMAIL_DOMAIN = "costacloud.com";

		 if (!registrationDto.getEmail().endsWith("@" + EMAIL_DOMAIN)) {
	            throw new UserEmailDomainException("Email domain should be " + EMAIL_DOMAIN);
	        }
		
		Registration registration = new Registration(

				registrationDto.getUserName(), registrationDto.getRole(), registrationDto.getDept(),
				registrationDto.getEmail(), this.passwordEncoder.encode(registrationDto.getPassword()),
				registrationDto.getMobile()

		);

		

		try {
			registrationRepo.save(registration);
			
		}catch (DataIntegrityViolationException e) {
			if (e.getMessage().contains("mobile")) {
				throw new DuplicateMobileNumberException("Username already exists");
			} else if (e.getMessage().contains("email")) {
				throw new DuplicateEmailException("Email already exists");
			} else {
				e.printStackTrace();
				throw e;
			}
		}
		
		
		
		return registration.getUserName();
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
	    public Registration updateUser(int id, RegistrationDto registrationDto) {
		 Registration user = registrationRepo.findById(id);
//				  Tickets ticket = ticketRepository.findByTicketId(id);
//	                .orElseThrow(() -> new UserNotFoundException(id));
	        user.setUserName(registrationDto.getUserName());
	        user.setEmail(registrationDto.getEmail());
	        user.setPassword( this.passwordEncoder.encode(registrationDto.getPassword()));
	        return registrationRepo.save(user);
	    }

	 
	 @Override
	    public Registration findById(int id) {
	        return registrationRepo.findById(id);
//	                .orElseThrow(() -> new UserNotFoundException(id));
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
