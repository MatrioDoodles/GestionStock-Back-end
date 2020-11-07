package com.GestionStock.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.GestionStock.app.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
	
	public Company findBytenantid(long tenant_id);

}
