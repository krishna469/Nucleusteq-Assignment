package com.krishna.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.krishna.dto.LoginDto;
import com.krishna.dto.RegistrationDto;
import com.krishna.entity.Registration;
import com.krishna.exception.DuplicateEmailException;
import com.krishna.exception.DuplicateMobileNumberException;
import com.krishna.exception.UserEmailDomainException;
import com.krishna.exception.UserNotFoundException;
import com.krishna.response.LoginResponse;
import com.krishna.service.RegistrationService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/users")
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;

	@PostMapping(path = "/save")
	public ResponseEntity<?>  saveUser(@RequestBody RegistrationDto registrationDto){

		HashMap<String, Object> res=new HashMap<>();
		
		 try {
	            String message = registrationService.addUser(registrationDto);
	            return ResponseEntity.ok(message);
	        } catch (DuplicateMobileNumberException e) {
	        	res.put("message", e.getMessage());
	            return ResponseEntity.status(HttpStatus.CONFLICT).body(res);
	        } catch (DuplicateEmailException e) {
	        	res.put("message", e.getMessage());
	            return ResponseEntity.status(HttpStatus.CONFLICT).body(res);
	        } catch (UserEmailDomainException e) {
	        	res.put("message", e.getMessage());
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
	        } catch (Exception e) {
	        	
	        	res.put("message", "An error occurred while processing your request");
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
	        }	

	}

	@ExceptionHandler(DuplicateMobileNumberException.class)
	public ResponseEntity<String> handleDuplicateUsernameException(DuplicateMobileNumberException e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}


	@PostMapping(path = "/login")
	public ResponseEntity<?> loginUser(@RequestBody LoginDto loginDto) {

		LoginResponse loginResponse = registrationService.loginUser(loginDto);
		return ResponseEntity.ok(loginResponse);

	}
	
	

	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateUser(@PathVariable int id, @RequestBody RegistrationDto userDto) throws UserNotFoundException {
	
		HashMap<String, Object> res=new HashMap<>();
		
		 try {
	            String message = registrationService.updateUser(id, userDto);
	            return ResponseEntity.ok(message);
	        } catch (UserNotFoundException e) {
	        	res.put("message", e.getMessage());
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
	        }catch(Exception e) {
	        	res.put("message", "Something went worng !! try Again");
	        	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
	        }
	}
	
	

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable int id) throws UserNotFoundException {
		
		HashMap<String, Object> res=new HashMap<>(); 
		 try {
	            Registration user = registrationService.findById(id);
	            return ResponseEntity.ok(user);
	        }catch (UserNotFoundException e) {
	        	res.put("message", e.getMessage());
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
	        }
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
