package com.GestionStock.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.GestionStock.app.model.Warehouse;
import com.GestionStock.app.repository.WarehouseRepository;
import com.GestionStock.app.service.WarehouseService;

@Service("WarehouseServiceImpl")
public class WarehouseServiceImpl implements WarehouseService{

	@Autowired
	private WarehouseRepository WarehouseRepository;

	@Transactional
	public Warehouse addWarehouse(Warehouse Warehouse) {
		return WarehouseRepository.save(Warehouse);
	}

	@Transactional(readOnly = true)
	public List<Warehouse> allWarehouse() {
		
		return WarehouseRepository.findAll();
	}

	@Transactional
	public Warehouse updateWarehouse(Warehouse Warehouse) {
		return WarehouseRepository.save(Warehouse);
	}

	@Transactional
	public void deleteWarehouse(long Warehouse) {
		WarehouseRepository.deleteById(Warehouse);
		
	}

	@Transactional(readOnly = true)
	public Warehouse findWarehouseById(long id_Warehouse) {
		return WarehouseRepository.findById(id_Warehouse).get();
	}

	@Transactional(readOnly = true)
	public List<Warehouse> getWarehousesByTenantId(long tenant_id) {
		return WarehouseRepository.findBytenantid(tenant_id);
	}

	@Transactional(readOnly = true)
	public long nbWarehousesByTenantId(long tenant_id) {
		return WarehouseRepository.findBytenantid(tenant_id).size();
	}
}
