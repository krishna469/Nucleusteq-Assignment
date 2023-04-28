package com.krishna.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krishna.dto.TicketDto;
import com.krishna.entity.Tickets;
import com.krishna.repo.CategoryRepository;
import com.krishna.repo.TicketRepository;
import com.krishna.service.TicketService;

@Service
public class TicketImpl implements TicketService {

	@Autowired
	private TicketRepository ticketRepository;
	
	 @Override
	    public String createTicket(TicketDto ticketDto) {
	        // Convert TicketDto to Ticket entity
	        Tickets ticket = new Tickets();
	        ticket.setUser(ticketDto.getUser());
	        ticket.setCategory(ticketDto.getCategory());
	        ticket.setSubcategory(ticketDto.getSubcategory());
	        ticket.setDescription(ticketDto.getDescription());
	        ticket.setPriority(ticketDto.getPriority());
	        ticket.setStatus(ticketDto.getStatus());
	        ticket.setReplay(ticketDto.getReplay());

	        ticket.setStatus("Initiated");
	        ticket.setCreationDateTime(LocalDateTime.now());
	        ticket.setEndDate(ticketDto.getEndDate());
	        // Save Ticket entity to database
	        Tickets savedTicket = ticketRepository.save(ticket);

	        return "Ticket created with id: " + savedTicket.getTicketId();
	    }



	@Override
	public List<Tickets> getAllTickets() {
		return ticketRepository.findAll();
	}
	
	 @Override
	    public Tickets findByTicketId(int id) {
	        return ticketRepository.findByTicketId(id);
	    }
	 
	 
	    @Override
	    public Tickets updateTicket(int id, TicketDto updatedticketDto) {

	    	
	    	Tickets ticket = ticketRepository.findByTicketId(id);
	        if (updatedticketDto.getCategory() != null) {
	            ticket.setCategory(updatedticketDto.getCategory());
	        }
	        ticket.setStatus(updatedticketDto.getStatus());
	        ticket.setPriority(updatedticketDto.getPriority());
	        ticket.setReplay(updatedticketDto.getReplay());
	        ticket.setDescription(updatedticketDto.getDescription());
	        ticket.setEndDate(LocalDateTime.now());
	        return ticketRepository.save(ticket);
	    	
	    	
	    	//	        Tickets ticket = ticketRepository.findByTicketId(id);
////	                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found with id " + id));

	    }
	    
	    @Override
	    public void deleteTicketById(int id) {
	        ticketRepository.deleteById(id);
	    }

}