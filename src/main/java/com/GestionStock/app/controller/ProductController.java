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

import com.GestionStock.app.model.Product;
import com.GestionStock.app.service.ProductService;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/products")
public class ProductController {

	@Autowired
	private ProductService ProductService;
	
	@GetMapping("/GetAllProducts")
	public List<Product> GetAllProducts()
	{
		return ProductService.allProduct();
	}
	
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product Product) {
		
		return ProductService.addProduct(Product);
	}
	@GetMapping("/GetProductsByWarehouse/{warehouse}")
	public List<Product> GetProductsByWarehouse(@PathVariable long warehouse) {
		
		return ProductService.getProductsByWarehouse(warehouse);
	}
	@GetMapping("/GetProductsBySupplier/{supplier}")
	public List<Product> GetProductsBySupplier(@PathVariable long supplier) {
		
		return ProductService.getProductsBySupplier(supplier);
	}
	@GetMapping("/GetProductsByCategory/{category}")
	public List<Product> GetProductsByCategory(@PathVariable long category) {
		
		return ProductService.getProductsByCaterory(category);
	}
	@PutMapping("/ModProduct")
	public Product ModProduct(@RequestBody Product Product) {
		
		return ProductService.updateProduct(Product);
	}
	@GetMapping("/{id}")
	public Product GetProductByid(@PathVariable long id) {
		return ProductService.findProductById(id);
	}
	@GetMapping("/GetAllProductsT/{id}")
	public List<Product> GetProductByTenantId(@PathVariable long id) {
		return ProductService.getProductsByTenantId(id);
	}

	@DeleteMapping("/DelProduct")
	public void DelAscenseur(@RequestBody Product Product) {
		
		ProductService.deleteProduct(Product);
			//return "Produit Supprimé";
	}
}
