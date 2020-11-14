package com.GestionStock.app.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.GestionStock.app.model.Product;


@Component
public interface ProductService {
	
	public Product addProduct(Product Product);
	public Product updateProduct(Product Product);
	public void deleteProduct(long Product);
	public Product findProductById(long id_Product);
	public List<Product> allProduct();
	public List<Product> getProductsByTenantId(long tenant_id);
	public List<Product> getProductsByWarehouse(long warehouse);
	public List<Product> getProductsByCaterory(long category);
	public List<Product> getProductsBySupplier(long supplier);
	public long nbProductsByTenantId(long tenant_id);
}
