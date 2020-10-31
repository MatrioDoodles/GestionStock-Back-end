package com.GestionStock.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GestionStock.app.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

	public List<Category> getSousCategories(Category category_primary);
	public List<Category> getCategoriesByTenantId(long tenant_id);
}
