package com.GestionStock.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.GestionStock.app.model.Category;
import com.GestionStock.app.repository.CategoryRepository;
import com.GestionStock.app.service.CategoryService;

@Service("CategoryServiceImpl")
public class CategoryServiceImpl implements CategoryService {

	
	@Autowired
	private CategoryRepository CategoryRepository;

	@Transactional
	public Category addCategory(Category Category) {
		return CategoryRepository.save(Category);
	}

	@Transactional(readOnly = true)
	public List<Category> allCategory() {
		
		return CategoryRepository.findAll();
	}

	@Transactional
	public Category updateCategory(Category Category) {
		return CategoryRepository.save(Category);
	}

	@Transactional
	public void deleteCategory(Category Category) {
		CategoryRepository.delete(Category);
		
	}

	@Transactional(readOnly = true)
	public Category findCategoryById(long id_Category) {
		return CategoryRepository.findById(id_Category).get();
	}

	@Transactional(readOnly = true)
	public List<Category> getSousCategories(long category_primary) {
		return CategoryRepository.findBycategoryprimary_Id(category_primary);
	}

	@Transactional(readOnly = true)
	public List<Category> getCategoriesByTenantId(long tenant_id) {
		return CategoryRepository.findBytenantid(tenant_id);
	}

	@Transactional(readOnly = true)
	public long nbCategoriesByTenantId(long tenant_id) {
		return CategoryRepository.findBytenantid(tenant_id).size();
	}
}
