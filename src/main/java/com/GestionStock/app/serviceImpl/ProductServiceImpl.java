package com.GestionStock.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.GestionStock.app.model.Category;
import com.GestionStock.app.model.Product;
import com.GestionStock.app.model.Supplier;
import com.GestionStock.app.model.Warehouse;
import com.GestionStock.app.repository.ProductRepository;
import com.GestionStock.app.service.ProductService;


@Service("ProductServiceImpl")
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository ProductRepository;

	@Transactional
	public Product addProduct(Product Product) {
		return ProductRepository.save(Product);
	}

	@Transactional(readOnly = true)
	public List<Product> allProduct() {
		
		return ProductRepository.findAll();
	}

	@Transactional
	public Product updateProduct(Product Product) {
		return ProductRepository.save(Product);
	}

	@Transactional
	public void deleteProduct(Product Product) {
		ProductRepository.delete(Product);
		
	}

	@Transactional(readOnly = true)
	public Product findProductById(Long id_Product) {
		return ProductRepository.findById(id_Product).get();
	}

	@Transactional(readOnly = true)
	public List<Product> getProductsByTenantId(long tenant_id) {
		return ProductRepository.findBytenantid(tenant_id);
	}

	@Transactional(readOnly = true)
	public List<Product> getProductsByWarehouse(Warehouse warehouse) {
		return ProductRepository.findBywarehouse(warehouse);
	}

	@Transactional(readOnly = true)
	public List<Product> getProductsByCaterory(Category category) {
		return ProductRepository.findBycategory(category);
	}

	@Transactional(readOnly = true)
	public List<Product> getProductsBySupplier(Supplier supplier) {
		return ProductRepository.findBysupplier(supplier);
	}

	@Transactional(readOnly = true)
	public long nbProductsByTenantId(long tenant_id) {
		return ProductRepository.findBytenantid(tenant_id).size();
	}
}
