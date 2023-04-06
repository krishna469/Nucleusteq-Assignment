package com.krishna.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.krishna.exception.UserNotFoundException;
import com.krishna.model.User;
import com.krishna.repository.UserRepository;


@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    User newUser(@RequestBody User newUser){
        return userRepository.save(newUser);
    }
    
    @GetMapping("/users")
    List<User>getAllUsers(){
    	
    	return userRepository.findAll();
    }
    
    @GetMapping("/user/{id}")
    User getUserById(@PathVariable Long id) {
    	
    	return userRepository.findById(id)
    			.orElseThrow(()->new UserNotFoundException(id));
    }
    
    @PutMapping("/user/{id}")
    User updateUser(@RequestBody User newUser,@PathVariable Long id) {
    
    	return userRepository.findById(id)
		    .map(user ->{
		    	
		    	user.setCity(newUser.getCity());
		    	user.setName(newUser.getName());
		    	user.setEmail(newUser.getEmail());
		    	return userRepository.save(user);
		    }).orElseThrow(()->new UserNotFoundException(id));
    }
    
    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id) {
    	if(!userRepository.existsById(id)) {
    		throw new UserNotFoundException(id);
    	}
    	userRepository.deleteById(id);
    	return "User with id "+id+" has been deleted successfully.";
    }
}



















