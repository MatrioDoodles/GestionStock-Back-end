package com.GestionStock.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GestionStock.app.model.Category;
import com.GestionStock.app.service.CategoryService;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/categories")
public class CategoryController {

	@Autowired
	private CategoryService CategoryService;
	
	@GetMapping("/GetAllCategorys")
	public List<Category> GetAllCategorys()
	{
		return CategoryService.allCategory();
	}
	@GetMapping("/GetAllPrimaryCategorys")
	public List<Category> GetAllPrimaryCategorys()
	{
		return CategoryService.getAllPrimaryCategories();
	}
	@GetMapping("/GetAllPrimaryCategorysT/{id}")
	public List<Category> GetAllPrimaryCategorysT(@PathVariable long id)
	{
		return CategoryService.getAllPrimaryCategoriesT(id);
	}
	
	@PostMapping("/addCategory")
	public Category addCategory(@RequestBody Category Category) {
		
		return CategoryService.addCategory(Category);
	}
	@PutMapping("/ModCategory")
	public Category ModCategory(@RequestBody Category Category) {
		
		return CategoryService.updateCategory(Category);
	}
	@GetMapping("/SousCat/{category_primary}")
	public List<Category> GetSousCategory(@PathVariable long category_primary) {
		return CategoryService.getSousCategories(category_primary);
	}
	@GetMapping("/GetAllCategoriesT/{id}")
	public List<Category> getCategoriesByTenantId(@PathVariable long id) {
		return CategoryService.getCategoriesByTenantId(id);
	}
	
	@GetMapping("/{id}")
	public Category GetCategoryByid(@PathVariable long id) {
		return CategoryService.findCategoryById(id);
	}

	@DeleteMapping("/DelCategory/{Category}")
	public void DelAscenseur(@PathVariable long Category) {
		
		CategoryService.deleteCategory(Category);
			//return "Categorie Supprimé";
	}
}
