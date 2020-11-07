package com.GestionStock.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GestionStock.app.model.Category;
import com.GestionStock.app.model.Product;
import com.GestionStock.app.model.Supplier;
import com.GestionStock.app.model.Warehouse;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	
	public List<Product> findBytenantid(long tenant_id);
	public List<Product> findBywarehouse(Warehouse warehouse);
	public List<Product> findBycategory(Category category);
	public List<Product> findBysupplier(Supplier supplier);
	
}
