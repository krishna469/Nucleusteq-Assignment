package com.krishna.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krishna.dto.TicketDto;
import com.krishna.entity.Tickets;
import com.krishna.service.TicketService;


@RestController
//@CrossOrigin
@RequestMapping("/api/ticket")
public class TicketController {

	@Autowired
    private TicketService ticketService;

    @PostMapping("/save")
    public String createTickets(@Validated @RequestBody TicketDto ticketDto) {
        return ticketService.createTicket(ticketDto);
    }
    
    
    @GetMapping
    public List<Tickets> getAllTickets() {
        return ticketService.getAllTickets();
    }

    
    @GetMapping("/{id}")
    public Tickets getTicketById(@PathVariable int id) {
        return ticketService.findByTicketId(id);
    }
    
    
    @PutMapping("/update/{id}")
    public Tickets update(@PathVariable int id, @RequestBody TicketDto updateTicketDto) {
        return ticketService.updateTicket(id, updateTicketDto);
    }
    
    
    
    @DeleteMapping("delete/{id}")
    public void deleteTicketById(@PathVariable int id) {
        ticketService.deleteTicketById(id);
    }
    
    
    
    @GetMapping("/status/{status}")
    public List<Tickets> getTicketByStatus(@PathVariable String status) {
        List<Tickets> allTickets = ticketService.getAllTickets();
        List<Tickets> filteredTickets = new ArrayList<>();
        for (Tickets ticket : allTickets) {
        	System.out.println("===="+ticket.getStatus());
            if (ticket.getStatus() != null && ticket.getStatus().equalsIgnoreCase(status)) {
            	filteredTickets.add(ticket);
            }
        }
        return filteredTickets;
    }
    
    @GetMapping("user/status/{userId}")
    public List<Tickets> getTicketByUserId(@PathVariable int userId) {
        List<Tickets> allTickets = ticketService.getAllTickets();
        List<Tickets> filteredTickets = new ArrayList<>();
        for (Tickets ticket : allTickets) {
            if ((ticket.getUser().getId())==(userId)) {
            	filteredTickets.add(ticket);
            }
        }
        return filteredTickets;
    }
    
    @GetMapping("search/{term}")
    public List<Tickets> searchInDatabase(@PathVariable String term) {
        List<Tickets> allTickets = ticketService.getAllTickets();
        List<Tickets> filteredTickets = new ArrayList<>();
        for (Tickets ticket : allTickets) {
            if ((ticket.getUser().getId()+"").equals(term)||(ticket.getUser().getUserName()).contains(term) || ticket.getDescription().contains(term)) {
            	filteredTickets.add(ticket);
            }
        }
        return filteredTickets;
    }
    
}
