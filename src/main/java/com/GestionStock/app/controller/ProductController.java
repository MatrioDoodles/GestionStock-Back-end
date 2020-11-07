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
import com.GestionStock.app.model.Product;
import com.GestionStock.app.model.Supplier;
import com.GestionStock.app.model.Warehouse;
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
	@PostMapping("/GetProductsByWarehouse")
	public List<Product> GetProductsByWarehouse(@RequestBody Warehouse warehouse) {
		
		return ProductService.getProductsByWarehouse(warehouse);
	}
	@PostMapping("/GetProductsBySupplier")
	public List<Product> GetProductsBySupplier(@RequestBody Supplier supplier) {
		
		return ProductService.getProductsBySupplier(supplier);
	}
	@PostMapping("/GetProductsByCategory")
	public List<Product> GetProductsByCategory(@RequestBody Category category) {
		
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
