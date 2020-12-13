package com.GestionStock.app.service;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.GestionStock.app.model.Company;

@Component
public interface CompanyService {

	public void init();
	public Company addCompany(Company Company);
	public Company updateCompany(Company Company);
	public void deleteCompany(long Company);
	public Company findCompanyById(long id_Company);
	public List<Company> allCompany();
	public Company getCompanyByTenantId(long tenant_id);
	public void save(MultipartFile file,long id);
	public Resource load(long id);
	public Stream<Path> loadAll();
}
