package com.krishna.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.krishna.entity.Tickets;

import io.micrometer.common.lang.Nullable;

@EnableJpaRepositories
@Repository
public interface TicketRepository extends JpaRepository<Tickets, Integer>{


	Tickets findByTicketId(int ticketId);
    public List<Tickets> findAll();
    void deleteById(int id);
	

}
