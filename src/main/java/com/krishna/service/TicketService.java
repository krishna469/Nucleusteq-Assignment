package com.krishna.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.krishna.dto.TicketDto;
import com.krishna.entity.Tickets;

@Service
public interface TicketService {

	
	
	//Ticket createTicket
	//replay to ticket
	public String createTicket(TicketDto ticketDto);
	
	List<Tickets> getAllTickets();
	//List<Tickets> getAllTickets();
	Tickets findByTicketId(int id);
	Tickets updateTicket(int id, TicketDto ticketDto);
	void deleteTicketById(int id);
    
}
