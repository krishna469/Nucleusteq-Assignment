package com.krishna.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "categories")
@SequenceGenerator(name = "category_seq", initialValue = 3010, allocationSize = 1)
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_seq")
	@NotNull
	private int id;
	
	@NotNull
	private String name;

	

	public Category(int id, @NotNull String name) {
		super();
		this.id = id;
		this.name = name;
	}
//	 public Category(String categoryName) {
//	        this.name = categoryName;
//	    }
	 
	
	 public Category() {}

	    public Category(String categoryName) {
	        this.name = categoryName;
	    }
//	public Category() {
//		super();
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}
	
		
	
}
