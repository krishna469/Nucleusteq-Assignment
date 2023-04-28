package com.krishna.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krishna.dto.CategoryDto;
import com.krishna.dto.SubcategoryDto;
import com.krishna.entity.Category;
import com.krishna.entity.Subcategory;
import com.krishna.repo.CategoryRepository;
import com.krishna.repo.SubcategoryRepository;
import com.krishna.service.CategoryService;

import java.util.Optional;

@Service
public class CategoryImpl implements CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private SubcategoryRepository subcategoryRepository;
	

	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category category = new Category(categoryDto.getId(), categoryDto.getName());
		categoryRepository.save(category);

		CategoryDto createdCategoryDto = new CategoryDto();
		createdCategoryDto.setId(category.getId());
		createdCategoryDto.setName(category.getName());
		

		return createdCategoryDto;
	}
	

	@Override
	public SubcategoryDto createSubcategory(SubcategoryDto subcategoryDto) {
	    Subcategory subcategory = new Subcategory(subcategoryDto.getId(), subcategoryDto.getName(),subcategoryDto.getCategory());
	    Subcategory save = subcategoryRepository.save(subcategory);
	    //System.err.println("data==>>"+save.getName());
	    SubcategoryDto createdSubcategoryDto = new SubcategoryDto();
	    createdSubcategoryDto.setId(subcategory.getId());
	    createdSubcategoryDto.setName(subcategory.getName());
	    createdSubcategoryDto.setCategory(subcategory.getCategory());

	    return createdSubcategoryDto;
	}


	@Override
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();

	}

	@Override
	public CategoryDto getCategoryById(int id) {
		Optional<Category> optionalCategory = categoryRepository.findById(id);
		if (optionalCategory.isPresent()) {
			Category category = optionalCategory.get();
			CategoryDto categoryDto = new CategoryDto();
			categoryDto.setId(category.getId());
			categoryDto.setName(category.getName());
			return categoryDto;
		} else {
			throw new RuntimeException("Category not found for id: " + id);
		}
	}
	
	 @Override
	    public CategoryDto updateCategory(int categoryId, CategoryDto categoryDto) {
	        Category category = categoryRepository.findById(categoryId).orElse(null);
//	                .orElseThrow(() -> new EntityNotFoundException("Category not found"));

	        category.setName(categoryDto.getName());
	        
	        category = categoryRepository.save(category);
	        
	        CategoryDto createdCategoryDto = new CategoryDto();
	        createdCategoryDto.setId(category.getId());
	        createdCategoryDto.setName(category.getName());
			return createdCategoryDto;
	    }

	    @Override
	    public void deleteCategory(int categoryId) {
	        categoryRepository.deleteById(categoryId);
	    }
	    
	    @Override
	    public void deleteSubcategory(int subcategoryId) {
	        subcategoryRepository.deleteById(subcategoryId);
	    }
	
	
	    @Override
		public List<Subcategory> getAllSubcategories() {
			return subcategoryRepository.findAll();

		}
	    
		@Override
		public SubcategoryDto getSubcategoriesById(int id) {
			Optional<Subcategory> optionalCategory = subcategoryRepository.findById(id);
			if (optionalCategory.isPresent()) {
				Subcategory subCategory = optionalCategory.get();
				SubcategoryDto subcategoryDto = new SubcategoryDto();
				subcategoryDto.setId(subCategory.getId());
				subcategoryDto.setName(subCategory.getName());
				return subcategoryDto;
			} else {
				throw new RuntimeException("Category not found for id: " + id);
			}
		}
		
		 @Override
		    public SubcategoryDto updateSubcategory(int subCategoryId, SubcategoryDto subcategoryDto) {
			 Subcategory subcategory = subcategoryRepository.findById(subCategoryId).orElse(null);
//		                .orElseThrow(() -> new EntityNotFoundException("Category not found"));

			 subcategory.setName(subcategoryDto.getName());
		        
			 subcategory = subcategoryRepository.save(subcategory);
		        
			 SubcategoryDto createdSubcategoryDto = new SubcategoryDto();
			 createdSubcategoryDto.setId(subcategory.getId());
			 createdSubcategoryDto.setName(subcategory.getName());
				return createdSubcategoryDto;
		    }
	
}









//package com.krishna.service.impl;
//
//import java.util.List;
//
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.krishna.dto.CategoryDto;
//import com.krishna.dto.SubcategoryDto;
//import com.krishna.entity.Category;
//import com.krishna.entity.Subcategory;
//import com.krishna.repo.CategoryRepository;
//import com.krishna.repo.SubcategoryRepository;
//import com.krishna.service.CategoryService;
//
//import java.util.Optional;
//
//@Service
//public class CategoryImpl implements CategoryService {
//	@Autowired
//	private CategoryRepository categoryRepository;
//
//	@Autowired
//	private SubcategoryRepository subcategoryRepository;
//	
//
//	public CategoryDto createCategory(CategoryDto categoryDto) {
////		List<Subcategory> sub=new ArrayList<>();
////		sub.add(categoryDto.getSubcategory());
//		Category category = new Category(categoryDto.getId(), categoryDto.getName(),categoryDto.getSubcategory());
////		category.setSubcategory(categoryDto.getSubcategory());
//		categoryRepository.save(category);
//
//		CategoryDto createdCategoryDto = new CategoryDto();
//		createdCategoryDto.setId(category.getId());
//		createdCategoryDto.setName(category.getName());
//		
//
//		return createdCategoryDto;
//	}
//	
//	
////	public CategoryDto createCategory(CategoryDto categoryDto) {
////		
////		 Category category = new Category();
////		    category.setName(categoryDto.getName());
////
////		    Subcategory subcategory = subcategoryRepository.findById(categoryDto.getSubcategory())
////		        .orElseThrow(null);//() -> new ResourceNotFoundException("Subcategory not found"));
////		    category.setSubcategory(subcategory);
////
////		    Category savedCategory = categoryRepository.save(category);
////
////		    CategoryDto savedCategoryDto = new CategoryDto();
////		    savedCategoryDto.setId(savedCategory.getId());
////		    savedCategoryDto.setName(savedCategory.getName());
////		    savedCategoryDto.setSubcategory(savedCategory.getSubcategory());
////
////		    return savedCategoryDto;
////	}
//	
//	
//
//	
//
//	@Override
//	public SubcategoryDto createSubcategory(SubcategoryDto subcategoryDto) {
//	    Subcategory subcategory = new Subcategory(subcategoryDto.getId(), subcategoryDto.getName());
//	    subcategoryRepository.save(subcategory);
//
//	    SubcategoryDto createdSubcategoryDto = new SubcategoryDto();
//	    createdSubcategoryDto.setId(subcategory.getId());
//	    createdSubcategoryDto.setName(subcategory.getName());
//
//	    return createdSubcategoryDto;
//	}
//
//
//	@Override
//	public List<Category> getAllCategories() {
//		return categoryRepository.findAll();
//
//	}
//
//	@Override
//	public CategoryDto getCategoryById(int id) {
//		Optional<Category> optionalCategory = categoryRepository.findById(id);
//		if (optionalCategory.isPresent()) {
//			Category category = optionalCategory.get();
//			CategoryDto categoryDto = new CategoryDto();
//			categoryDto.setId(category.getId());
//			categoryDto.setName(category.getName());
//			return categoryDto;
//		} else {
//			throw new RuntimeException("Category not found for id: " + id);
//		}
//	}
//	
//	 @Override
//	    public CategoryDto updateCategory(int categoryId, CategoryDto categoryDto) {
//	        Category category = categoryRepository.findById(categoryId).orElse(null);
////	                .orElseThrow(() -> new EntityNotFoundException("Category not found"));
//
//	        category.setName(categoryDto.getName());
//	        
//	        category = categoryRepository.save(category);
//	        
//	        CategoryDto createdCategoryDto = new CategoryDto();
//	        createdCategoryDto.setId(category.getId());
//	        createdCategoryDto.setName(category.getName());
//			return createdCategoryDto;
//	    }
//
//	    @Override
//	    public void deleteCategory(int categoryId) {
//	        categoryRepository.deleteById(categoryId);
//	    }
//	    
//	    @Override
//	    public void deleteSubcategory(int subcategoryId) {
//	        subcategoryRepository.deleteById(subcategoryId);
//	    }
//	
//	
//	    @Override
//		public List<Subcategory> getAllSubcategories() {
//			return subcategoryRepository.findAll();
//
//		}
//	    
//		@Override
//		public SubcategoryDto getSubcategoriesById(int id) {
//			Optional<Subcategory> optionalCategory = subcategoryRepository.findById(id);
//			if (optionalCategory.isPresent()) {
//				Subcategory subCategory = optionalCategory.get();
//				SubcategoryDto subcategoryDto = new SubcategoryDto();
//				subcategoryDto.setId(subCategory.getId());
//				subcategoryDto.setName(subCategory.getName());
//				return subcategoryDto;
//			} else {
//				throw new RuntimeException("Category not found for id: " + id);
//			}
//		}
//		
//		 @Override
//		    public SubcategoryDto updateSubcategory(int subCategoryId, SubcategoryDto subcategoryDto) {
//			 Subcategory subcategory = subcategoryRepository.findById(subCategoryId).orElse(null);
////		                .orElseThrow(() -> new EntityNotFoundException("Category not found"));
//
//			 subcategory.setName(subcategoryDto.getName());
//		        
//			 subcategory = subcategoryRepository.save(subcategory);
//		        
//			 SubcategoryDto createdSubcategoryDto = new SubcategoryDto();
//			 createdSubcategoryDto.setId(subcategory.getId());
//			 createdSubcategoryDto.setName(subcategory.getName());
//				return createdSubcategoryDto;
//		    }
//
//
//	
//}
