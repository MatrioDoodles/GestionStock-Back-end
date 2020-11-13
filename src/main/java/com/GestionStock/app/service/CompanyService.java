package com.GestionStock.app.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.GestionStock.app.model.Company;

@Component
public interface CompanyService {

	public Company addCompany(Company Company);
	public Company updateCompany(Company Company);
	public void deleteCompany(Company Company);
	public Company findCompanyById(long id_Company);
	public List<Company> allCompany();
	public Company getCompanyByTenantId(long tenant_id);
}
