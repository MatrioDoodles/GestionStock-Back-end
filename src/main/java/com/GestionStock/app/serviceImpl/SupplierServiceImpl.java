package com.GestionStock.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.GestionStock.app.model.Supplier;
import com.GestionStock.app.repository.SupplierRepository;
import com.GestionStock.app.service.SupplierService;


@Service("SupplierServiceImpl")
public class SupplierServiceImpl implements SupplierService{

	@Autowired
	private SupplierRepository SupplierRepository;

	@Transactional
	public Supplier addSupplier(Supplier Supplier) {
		return SupplierRepository.save(Supplier);
	}

	@Transactional(readOnly = true)
	public List<Supplier> allSupplier() {
		
		return SupplierRepository.findAll();
	}

	@Transactional
	public Supplier updateSupplier(Supplier Supplier) {
		return SupplierRepository.save(Supplier);
	}

	@Transactional
	public void deleteSupplier(Supplier Supplier) {
		SupplierRepository.delete(Supplier);
		
	}

	@Transactional(readOnly = true)
	public Supplier findSupplierById(Long id_Supplier) {
		return SupplierRepository.findById(id_Supplier).get();
	}

	@Transactional(readOnly = true)
	public List<Supplier> getSuppliersByTenantId(long tenant_id) {
		return SupplierRepository.getSuppliersByTenantId(tenant_id);
	}

	@Transactional(readOnly = true)
	public long nbSuppliersByTenantId(long tenant_id) {
		return SupplierRepository.getSuppliersByTenantId(tenant_id).size();
	}
}
