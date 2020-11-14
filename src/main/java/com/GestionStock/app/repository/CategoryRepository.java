package com.GestionStock.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GestionStock.app.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

	public List<Category> findBycategoryprimary_Id(long categoryprimary);
	public List<Category> findBytenantid(long tenant_id);
	public List<Category> findByCatprimaryFalse();
	public List<Category> findByCatprimaryFalseAndTenantid(long tenant_id);
}
