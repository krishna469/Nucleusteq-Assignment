package com.krishna.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.krishna.entity.Category;
import com.krishna.entity.Registration;
import com.krishna.entity.Subcategory;

@Component
public class TicketDto {
    
    private int ticketId;
    private Registration user;
    private Category category;
    private Subcategory subcategory;
    private String description;
    private String priority;
    private String status;
    private String replay;
    
    private LocalDateTime endDate;
    private LocalDateTime creationDateTime;
    
    public TicketDto() {
        super();
    }
    
    
    public TicketDto(int ticketId, Registration user, Category category, Subcategory subcategory, String description,
			String priority, String status, String replay, LocalDateTime endDate, LocalDateTime creationDateTime) {
		super();
		this.ticketId = ticketId;
		this.user = user;
		this.category = category;
		this.subcategory = subcategory;
		this.description = description;
		this.priority = priority;
		this.status = status;
		this.replay = replay;
		this.endDate = endDate;
		this.creationDateTime = creationDateTime;
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
        if (!isValidPriority(priority)) {
            throw new IllegalArgumentException("Invalid priority value: " + priority);
        }
        this.priority = priority;
    }

    private boolean isValidPriority(String priority) {
        return priority != null && (priority.equals("low") || priority.equals("medium") || priority.equals("high"));
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
    
    
    
    
    
    public LocalDateTime getEndDate() {
		return endDate;
	}


	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}


	public LocalDateTime getCreationDateTime() {
		return creationDateTime;
	}


	public void setCreationDateTime(LocalDateTime creationDateTime) {
		this.creationDateTime = creationDateTime;
	}


	@Override
	public String toString() {
		return "TicketDto [ticketId=" + ticketId + ", user=" + user + ", category=" + category + ", subcategory="
				+ subcategory + ", description=" + description + ", priority=" + priority + ", status=" + status
				+ ", replay=" + replay + ", endDate=" + endDate + ", creationDateTime=" + creationDateTime + "]";
	}


}


//@Component
//public class TicketDto {
//	
//	private int ticketId;
//	private Registration user;
//	private Category problemCat;
//	private String description;
//	private String priority;
//	private String status = "initiated";
//	private String replay;
//	
//	public TicketDto(int ticketId, Registration user, Category problemCat, String description, String priority,
//			String status, String replay) {
//		super();
//		this.ticketId = ticketId;
//		this.user = user;
//		this.problemCat = problemCat;
//		this.description = description;
//		this.priority = priority;
//		this.status = status;
//		this.replay = replay;
//	}
//
//	public TicketDto() {
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
//	public Category getProblemCat() {
//		return problemCat;
//	}
//
//	public void setProblemCat(Category problemCat) {
//		this.problemCat = problemCat;
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
//		return "TicketDto [ticketId=" + ticketId + ", user=" + user + ", problemCat=" + problemCat + ", description="
//				+ description + ", priority=" + priority + ", status=" + status + ", replay=" + replay + "]";
//	}
//	
//	
//		
//	
//
//	
//
//}













//package com.krishna.dto;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//
//import org.springframework.stereotype.Component;
//
//import com.krishna.entity.Category;
//import com.krishna.entity.Registration;
//import com.krishna.entity.Subcategory;
//
//@Component
//public class TicketDto {
//    
//    private int ticketId;
//    private Registration user;
//    private Category category;
//    private String description;
//    private String priority;
//    private String status;
//    private String replay;
//    
//    private LocalDate endDate;
//    private LocalDateTime creationDateTime;
//    
//    public TicketDto() {
//        super();
//    }
//    
//    
//    public TicketDto(int ticketId, Registration user, Category category, String description,
//			String priority, String status, String replay, LocalDate endDate, LocalDateTime creationDateTime) {
//		super();
//		this.ticketId = ticketId;
//		this.user = user;
//		this.category = category;
//		this.description = description;
//		this.priority = priority;
//		this.status = status;
//		this.replay = replay;
//		this.endDate = endDate;
//		this.creationDateTime = creationDateTime;
//	}
//
//
//	public int getTicketId() {
//        return ticketId;
//    }
//    
//    public void setTicketId(int ticketId) {
//        this.ticketId = ticketId;
//    }
//    
//    public Registration getUser() {
//        return user;
//    }
//    
//    public void setUser(Registration user) {
//        this.user = user;
//    }
//    
//    public Category getCategory() {
//        return category;
//    }
//    
//    public void setCategory(Category category) {
//        this.category = category;
//    }
//    
//    
//    public String getDescription() {
//        return description;
//    }
//    
//    public void setDescription(String description) {
//        this.description = description;
//    }
//    
//    public String getPriority() {
//        return priority;
//    }
//    
//    public void setPriority(String priority) {
//        if (!isValidPriority(priority)) {
//            throw new IllegalArgumentException("Invalid priority value: " + priority);
//        }
//        this.priority = priority;
//    }
//
//    private boolean isValidPriority(String priority) {
//        return priority != null && (priority.equals("low") || priority.equals("medium") || priority.equals("high"));
//    }
//    
//    public String getStatus() {
//        return status;
//    }
//    
//    public void setStatus(String status) {
//        this.status = status;
//    }
//    
//    public String getReplay() {
//        return replay;
//    }
//    
//    public void setReplay(String replay) {
//        this.replay = replay;
//    }
//    
//    
//    
//    
//    
//    public LocalDate getEndDate() {
//		return endDate;
//	}
//
//
//	public void setEndDate(LocalDate endDate) {
//		this.endDate = endDate;
//	}
//
//
//	public LocalDateTime getCreationDateTime() {
//		return creationDateTime;
//	}
//
//
//	public void setCreationDateTime(LocalDateTime creationDateTime) {
//		this.creationDateTime = creationDateTime;
//	}
//
//
//	@Override
//	public String toString() {
//		return "TicketDto [ticketId=" + ticketId + ", user=" + user + ", category=" + category + ", description=" + description + ", priority=" + priority + ", status=" + status
//				+ ", replay=" + replay + ", endDate=" + endDate + ", creationDateTime=" + creationDateTime + "]";
//	}
//
//
//}
//
