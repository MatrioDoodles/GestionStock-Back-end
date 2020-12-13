package com.GestionStock.app.service;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.GestionStock.app.model.Product;


@Component
public interface ProductService {
	
	
	public void init();
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
	public void save(MultipartFile file,long id);
	public Resource load(long id);
	public Stream<Path> loadAll();
}
