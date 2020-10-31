package com.GestionStock.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.GestionStock.app.model.Warehouse;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {

	public List<Warehouse> getWarehousesByTenantId(long tenant_id);
}
