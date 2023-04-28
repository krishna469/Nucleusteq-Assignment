package com.krishna.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "track_seq", initialValue = 7010, allocationSize = 1)
public class Track {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "track_seq")
	private int id;
	
	private int ticketId;
	private String priviousStatus;
	private String updatedStatus;
	private Date creationDate;
	private Date modificationDate;
	
	
	
}
//create a rest tracking api in spring boot to store the current status fetch from tickets entity,
	//new status from tickets entity,creation date and modification date from tickets entity, 
	//user who updated from user entity and ticket_id from tickets entity. packages is controller, 
	//service ,serviceimpl, dto and repository
	
