package com.krishna.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "subcategories")
@SequenceGenerator(name = "sub_category_seq", initialValue = 4010, allocationSize = 1)
public class Subcategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sub_category_seq")
	private int id;
	
	@NotNull
	private String name;
	
	@ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

	public Subcategory(int id, @NotNull String name, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
	}

	public Subcategory() {
		super();
	}

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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	
}
