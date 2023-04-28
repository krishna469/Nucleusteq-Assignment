package com.krishna.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "ticket_seq", initialValue = 5010, allocationSize = 1)
public class Tickets {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_seq")
	private int ticketId;
	
	
	@ManyToOne
	@JoinColumn(name = "user_id",nullable = false)
	private Registration user;
	
	
	@ManyToOne
    @JoinColumn(name = "category_id",nullable = false)
	private Category category;
	
	
	@ManyToOne
    @JoinColumn(name = "Subcategory_id",nullable = false)
	private Subcategory subcategory;
	
	@Column(nullable = false)
	private String description;
	
	
	private String priority;
	
	
	private String status = "initiated";
	private String replay;
	
	
    @Column(name = "creation_datetime", nullable = false)
    private LocalDateTime creationDateTime;

    @Column(name = "end_date")
    private LocalDateTime endDate;
	
	

	public Tickets(int ticketId, Registration user, Category category, Subcategory subcategory, String description,
			String priority, String status, String replay, LocalDateTime creationDateTime, LocalDateTime endDate) {
		super();
		this.ticketId = ticketId;
		this.user = user;
		this.category = category;
		this.subcategory = subcategory;
		this.description = description;
		this.priority = priority;
		this.status = status;
		this.replay = replay;
		this.creationDateTime = creationDateTime;
		this.endDate = endDate;
	}

	public Tickets() {
		super();
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public Registration getUser() {
		return user;
	}

	public void setUser(Registration user) {
		this.user = user;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Subcategory getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(Subcategory subcategory) {
		this.subcategory = subcategory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReplay() {
		return replay;
	}

	public void setReplay(String replay) {
		this.replay = replay;
	}

	
	
	public LocalDateTime getCreationDateTime() {
		return creationDateTime;
	}

	public void setCreationDateTime(LocalDateTime creationDateTime) {
		this.creationDateTime = creationDateTime;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Tickets [ticketId=" + ticketId + ", user=" + user + ", category=" + category + ", subcategory="
				+ subcategory + ", description=" + description + ", priority=" + priority + ", status=" + status
				+ ", replay=" + replay + ", creationDateTime=" + creationDateTime + ", endDate=" + endDate + "]";
	}

	
	
	
	
	
}
//	public Tickets(int ticketId, Registration user, Category category, String description, String priority,
//			String status, String replay) {
//		super();
//		this.ticketId = ticketId;
//		this.user = user;
//		this.category = category;
//		this.description = description;
//		this.priority = priority;
//		this.status = status;
//		this.replay = replay;
//	}
//
//	public Tickets() {
//		super();
//	}
//
//	public int getTicketId() {
//		return ticketId;
//	}
//
//	public void setTicketId(int ticketId) {
//		this.ticketId = ticketId;
//	}
//
//	public Registration getUser() {
//		return user;
//	}
//
//	public void setUser(Registration user) {
//		this.user = user;
//	}
//
//	public Category getCategory() {
//		return category;
//	}
//
//	public void setCategory(Category problemCat) {
//		this.category = problemCat;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//	public String getPriority() {
//		return priority;
//	}
//
//	public void setPriority(String priority) {
//		this.priority = priority;
//	}
//
//	public String getStatus() {
//		return status;
//	}
//
//	public void setStatus(String status) {
//		this.status = status;
//	}
//
//	public String getReplay() {
//		return replay;
//	}
//
//	public void setReplay(String replay) {
//		this.replay = replay;
//	}
//
//	@Override
//	public String toString() {
//		return "Tickets [ticketId=" + ticketId + ", user=" + user + ", problemCat=" + category + ", description="
//				+ description + ", priority=" + priority + ", status=" + status + ", replay=" + replay + "]";
//	}
//
//	
//}









//package com.krishna.entity;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.SequenceGenerator;
//
//@Entity
//@SequenceGenerator(name = "ticket_seq", initialValue = 5010, allocationSize = 1)
//public class Tickets {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_seq")
//	private int ticketId;
//	
//	
//	@ManyToOne
//	@JoinColumn(name = "user_id",nullable = false)
//	private Registration user;
//	
//	
//	@ManyToOne
//    @JoinColumn(name = "category_id",nullable = false)
//	private Category category;
//	
//
//	
//	@Column(nullable = false)
//	private String description;
//	
//	
//	private String priority;
//	
//	
//	private String status = "initiated";
//	private String replay;
//	
//	
//    @Column(name = "creation_datetime", nullable = false)
//    private LocalDateTime creationDateTime;
//
//    @Column(name = "end_date")
//    private LocalDate endDate;
//	
//	
//
//	public Tickets(int ticketId, Registration user, Category category, String description,
//			String priority, String status, String replay, LocalDateTime creationDateTime, LocalDate endDate) {
//		super();
//		this.ticketId = ticketId;
//		this.user = user;
//		this.category = category;
//		this.description = description;
//		this.priority = priority;
//		this.status = status;
//		this.replay = replay;
//		this.creationDateTime = creationDateTime;
//		this.endDate = endDate;
//	}
//
//	public Tickets() {
//		super();
//	}
//
//	public int getTicketId() {
//		return ticketId;
//	}
//
//	public void setTicketId(int ticketId) {
//		this.ticketId = ticketId;
//	}
//
//	public Registration getUser() {
//		return user;
//	}
//
//	public void setUser(Registration user) {
//		this.user = user;
//	}
//
//	public Category getCategory() {
//		return category;
//	}
//
//	public void setCategory(Category category) {
//		this.category = category;
//	}
//
//
//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//	public String getPriority() {
//		return priority;
//	}
//
//	public void setPriority(String priority) {
//		this.priority = priority;
//	}
//
//	public String getStatus() {
//		return status;
//	}
//
//	public void setStatus(String status) {
//		this.status = status;
//	}
//
//	public String getReplay() {
//		return replay;
//	}
//
//	public void setReplay(String replay) {
//		this.replay = replay;
//	}
//
//	
//	
//	public LocalDateTime getCreationDateTime() {
//		return creationDateTime;
//	}
//
//	public void setCreationDateTime(LocalDateTime creationDateTime) {
//		this.creationDateTime = creationDateTime;
//	}
//
//	public LocalDate getEndDate() {
//		return endDate;
//	}
//
//	public void setEndDate(LocalDate endDate) {
//		this.endDate = endDate;
//	}
//
//	@Override
//	public String toString() {
//		return "Tickets [ticketId=" + ticketId + ", user=" + user + ", category=" + category + ", description=" + description + ", priority=" + priority + ", status=" + status
//				+ ", replay=" + replay + ", creationDateTime=" + creationDateTime + ", endDate=" + endDate + "]";
//	}
//
//	
//	
//	
//	
//	
//}