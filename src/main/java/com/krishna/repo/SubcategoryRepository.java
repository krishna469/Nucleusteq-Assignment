package com.krishna.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.krishna.entity.Subcategory;

@Repository
public interface SubcategoryRepository  extends JpaRepository<Subcategory, Integer>{

	Optional<Subcategory> findById(Subcategory subcategory);

}
