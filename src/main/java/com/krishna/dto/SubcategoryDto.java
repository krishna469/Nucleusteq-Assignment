package com.krishna.dto;

import com.krishna.entity.Category;

import jakarta.validation.constraints.NotBlank;

public class SubcategoryDto {

	private int id;
	
	@NotBlank
	private String name;
	
	private Category category;

	public SubcategoryDto(int id, @NotBlank String name, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
	}

	public SubcategoryDto() {
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

	@Override
	public String toString() {
		return "SubcategoryDto [id=" + id + ", name=" + name + ", category=" + category + "]";
	}
	
		
	
	

}
