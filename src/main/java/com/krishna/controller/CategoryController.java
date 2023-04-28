package com.krishna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krishna.dto.CategoryDto;
import com.krishna.dto.SubcategoryDto;
import com.krishna.entity.Category;
import com.krishna.entity.Registration;
import com.krishna.entity.Subcategory;
import com.krishna.service.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    
    @PostMapping("/create")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
        CategoryDto savedCategoryDTO = categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(savedCategoryDTO, HttpStatus.CREATED);
    }
    
    @PostMapping("/subcategories/{categoryId}")
    public ResponseEntity<SubcategoryDto> createSubcategory(@PathVariable int categoryId, @RequestBody SubcategoryDto subcategoryDto) {
        CategoryDto categoryDTO = categoryService.getCategoryById(categoryId);
        SubcategoryDto savedSubcategoryDto = categoryService.createSubcategory(subcategoryDto);
//        categoryDTO.getSubcategories().add(savedSubcategoryDto);
        categoryService.createCategory(categoryDTO);
        return new ResponseEntity<>(savedSubcategoryDto, HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categorys = categoryService.getAllCategories();
        return new ResponseEntity<>(categorys, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
	public CategoryDto getCategoryById(@PathVariable int id) {
		return categoryService.getCategoryById(id);
	}
    
    @PutMapping("/{categoryId}")
    public CategoryDto updateCategory(@PathVariable int categoryId, @RequestBody @Valid CategoryDto categoryDTO) {
        return categoryService.updateCategory(categoryId, categoryDTO);
    }

    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable int categoryId) {
        categoryService.deleteCategory(categoryId);
    }
    
    @DeleteMapping("/subcat/{subcategoryId}")
    public void deleteSubcategory(@PathVariable int subcategoryId) {
        categoryService.deleteSubcategory(subcategoryId);
    }
    
    @GetMapping("/subcat")
    public ResponseEntity<List<Subcategory>> getAllSubcategories() {
        List<Subcategory> categorys = categoryService.getAllSubcategories();
        return new ResponseEntity<>(categorys, HttpStatus.OK);
    }
    
    @GetMapping("/subcat/{id}")
   	public SubcategoryDto getSubcategoriesById(@PathVariable int id) {
   		return categoryService.getSubcategoriesById(id);
   	}
    
    
    @PutMapping("/subat/{categoryId}")
    public SubcategoryDto updateSubcategory(@PathVariable int categoryId, @RequestBody @Valid SubcategoryDto subcategoryDto) {
        return categoryService.updateSubcategory(categoryId, subcategoryDto);
    }
}









//package com.krishna.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.krishna.dto.CategoryDto;
//import com.krishna.dto.SubcategoryDto;
//import com.krishna.entity.Category;
//import com.krishna.entity.Registration;
//import com.krishna.entity.Subcategory;
//import com.krishna.service.CategoryService;
//
//import jakarta.validation.Valid;
//
//@RestController
//@RequestMapping("/api/categories")
//public class CategoryController {
//    @Autowired
//    private CategoryService categoryService;
//    
//    @PostMapping("/create/{subCategoryId}")
//    public ResponseEntity<CategoryDto> createCategory(@PathVariable int subCategoryId,@RequestBody CategoryDto categoryDto) {
//
//      SubcategoryDto subcategoryDto = categoryService.getSubcategoriesById(subCategoryId);
//      CategoryDto savedCategoryDto= categoryService.createCategory(categoryDto);
//      categoryService.createSubcategory(subcategoryDto);
//      return new ResponseEntity<>(savedCategoryDto, HttpStatus.CREATED);
//        
//        
//        
//    }
//    
//    @PostMapping("/subcategories")
//    public ResponseEntity<SubcategoryDto> createSubcategory( @RequestBody SubcategoryDto subcategoryDto) {
////        CategoryDto categoryDTO = categoryService.getCategoryById(categoryId);
////        SubcategoryDto savedSubcategoryDto = categoryService.createSubcategory(subcategoryDto);
////        categoryService.createCategory(categoryDTO);
////        return new ResponseEntity<>(savedSubcategoryDto, HttpStatus.CREATED);
//    	
//    	SubcategoryDto SubcategoryDto = categoryService.createSubcategory(subcategoryDto);
//        return new ResponseEntity<>(SubcategoryDto, HttpStatus.CREATED);
//    }
//    
//    @GetMapping
//    public ResponseEntity<List<Category>> getAllCategories() {
//        List<Category> categorys = categoryService.getAllCategories();
//        return new ResponseEntity<>(categorys, HttpStatus.OK);
//    }
//    
//    @GetMapping("/{id}")
//	public CategoryDto getCategoryById(@PathVariable int id) {
//		return categoryService.getCategoryById(id);
//	}
//    
//    @PutMapping("/{categoryId}")
//    public CategoryDto updateCategory(@PathVariable int categoryId, @RequestBody @Valid CategoryDto categoryDTO) {
//        return categoryService.updateCategory(categoryId, categoryDTO);
//    }
//
//    @DeleteMapping("/{categoryId}")
//    public void deleteCategory(@PathVariable int categoryId) {
//        categoryService.deleteCategory(categoryId);
//    }
//    
//    @DeleteMapping("/subcat/{subcategoryId}")
//    public void deleteSubcategory(@PathVariable int subcategoryId) {
//        categoryService.deleteSubcategory(subcategoryId);
//    }
//    
//    @GetMapping("/subcat")
//    public ResponseEntity<List<Subcategory>> getAllSubcategories() {
//        List<Subcategory> categorys = categoryService.getAllSubcategories();
//        return new ResponseEntity<>(categorys, HttpStatus.OK);
//    }
//    
//    @GetMapping("/subcat/{id}")
//   	public SubcategoryDto getSubcategoriesById(@PathVariable int id) {
//   		return categoryService.getSubcategoriesById(id);
//   	}
//    
//    
//    @PutMapping("/subat/{categoryId}")
//    public SubcategoryDto updateSubcategory(@PathVariable int categoryId, @RequestBody @Valid SubcategoryDto subcategoryDto) {
//        return categoryService.updateSubcategory(categoryId, subcategoryDto);
//    }
//}
