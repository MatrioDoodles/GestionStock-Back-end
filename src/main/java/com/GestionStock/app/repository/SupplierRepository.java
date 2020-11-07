package com.GestionStock.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.GestionStock.app.model.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

	public List<Supplier> findBytenantid(long tenant_id);
}
