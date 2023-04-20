package com.krishna.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.krishna.entity.Registration;
import com.krishna.entity.Tickets;

@EnableJpaRepositories
@Repository
public interface RegistrationRepo extends JpaRepository<Registration, Integer> {
	
	Registration getByEmail(String email);

	Optional<Registration> findByEmailAndPassword(String email, String encodePassword);

	Optional<Registration> findByEmail(String email);
	
	Registration findById(int id);
	public List<Registration> findAll();
	void deleteById(int id);

}
