package com.GestionStock.app.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.GestionStock.app.model.Category;

@Component
public interface CategoryService {

	public Category addCategory(Category Category);
	public Category updateCategory(Category Category);
	public void deleteCategory(Category Category);
	public Category findCategoryById(long id_Category);
	public List<Category> allCategory();
	public List<Category> getSousCategories(long category_primary);
	public List<Category> getCategoriesByTenantId(long tenant_id);
	public long nbCategoriesByTenantId(long tenant_id);
}
