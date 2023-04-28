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








//package com.krishna.dto;
//
//import java.util.List;
//
//import com.krishna.entity.Subcategory;
//
//import jakarta.validation.constraints.NotBlank;
//
//public class CategoryDto {
//
//	private int id;
//	@NotBlank
//    private String name;
//	private List<Subcategory> subcategory;
//	public CategoryDto(int id, @NotBlank String name, List<Subcategory> subcategory) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.subcategory = subcategory;
//	}
//	public CategoryDto() {
//		super();
//	}
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public List<Subcategory> getSubcategory() {
//		return subcategory;
//	}
//	public void setSubcategory(List<Subcategory> subcategory) {
//		this.subcategory = subcategory;
//	}
//	@Override
//	public String toString() {
//		return "CategoryDto [id=" + id + ", name=" + name + ", subcategory=" + subcategory + "]";
//	}
//
//		
//
//}
