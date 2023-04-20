package com.krishna.dto;

import jakarta.validation.constraints.NotBlank;

public class CategoryDto {

	private int id;
	@NotBlank
    private String name;
	public CategoryDto(int id, @NotBlank String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public CategoryDto() {
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
	@Override
	public String toString() {
		return "CategoryDto [id=" + id + ", name=" + name + "]";
	}
    
		

}
