package com.GestionStock.app.service;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.GestionStock.app.model.Supplier;


@Component
public interface SupplierService {
	
	public void init();
	public Supplier addSupplier(Supplier Supplier);
	public Supplier updateSupplier(Supplier Supplier);
	public void deleteSupplier(long Supplier);
	public Supplier findSupplierById(long id_Supplier);
	public List<Supplier> allSupplier();
	public List<Supplier> getSuppliersByTenantId(long tenant_id);
	public long nbSuppliersByTenantId(long tenant_id);
	public void save(MultipartFile file,long id);
	public Resource load(long id);
	public Stream<Path> loadAll();
}
