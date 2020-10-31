package com.GestionStock.app.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.GestionStock.app.model.Warehouse;


@Component
public interface WarehouseService {

	public Warehouse addWarehouse(Warehouse Warehouse);
	public Warehouse updateWarehouse(Warehouse Warehouse);
	public void deleteWarehouse(Warehouse Warehouse);
	public Warehouse findWarehouseById(Long id_Warehouse);
	public List<Warehouse> allWarehouse();
	public List<Warehouse> getWarehousesByTenantId(long tenant_id);
	public long nbWarehousesByTenantId(long tenant_id);
}
