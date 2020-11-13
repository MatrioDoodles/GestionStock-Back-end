package com.GestionStock.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GestionStock.app.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	
	public List<Product> findBytenantid(long tenant_id);
	public List<Product> findBywarehouse_Id(long warehouse);
	public List<Product> findBycategory_Id(long category);
	public List<Product> findBysupplier_Id(long supplier);
	
}
