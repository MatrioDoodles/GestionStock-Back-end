package com.GestionStock.app.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.GestionStock.app.model.Category;
import com.GestionStock.app.model.Product;
import com.GestionStock.app.model.Supplier;
import com.GestionStock.app.model.Warehouse;


@Component
public interface ProductService {
	
	public Product addProduct(Product Product);
	public Product updateProduct(Product Product);
	public void deleteProduct(Product Product);
	public Product findProductById(Long id_Product);
	public List<Product> allProduct();
	public List<Product> getProductsByTenantId(long tenant_id);
	public List<Product> getProductsByWarehouse(Warehouse warehouse);
	public List<Product> getProductsByCaterory(Category category);
	public List<Product> getProductsBySupplier(Supplier supplier);
	public long nbProductsByTenantId(long tenant_id);
}
