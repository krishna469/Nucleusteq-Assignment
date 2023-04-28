package com.krishna.service;

import java.util.List;

import com.krishna.dto.CategoryDto;
import com.krishna.dto.SubcategoryDto;
import com.krishna.entity.Category;
import com.krishna.entity.Subcategory;

public interface CategoryService {
	
	
	CategoryDto createCategory(CategoryDto categoryDto);
	
    void deleteCategory(int categoryId);
    CategoryDto updateCategory(int categoryId, CategoryDto categoryDto);
    
	

	SubcategoryDto createSubcategory(SubcategoryDto subcategoryDto);
	

	List<Category> getAllCategories();

	CategoryDto getCategoryById(int id);
	

	void deleteSubcategory(int subcategoryId);

	List<Subcategory> getAllSubcategories();

	SubcategoryDto getSubcategoriesById(int id);

	SubcategoryDto updateSubcategory(int subCategoryId, SubcategoryDto subcategoryDto);

	

	
}
