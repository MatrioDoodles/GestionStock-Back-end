package com.GestionStock.app.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.GestionStock.app.model.Supplier;


@Component
public interface SupplierService {

	public Supplier addSupplier(Supplier Supplier);
	public Supplier updateSupplier(Supplier Supplier);
	public void deleteSupplier(Supplier Supplier);
	public Supplier findSupplierById(long id_Supplier);
	public List<Supplier> allSupplier();
	public List<Supplier> getSuppliersByTenantId(long tenant_id);
	public long nbSuppliersByTenantId(long tenant_id);
}
