package com.GestionStock.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.GestionStock.app.model.Company;
import com.GestionStock.app.repository.CompanyRepository;
import com.GestionStock.app.service.CompanyService;

@Service("CompanyServiceImpl")
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository CompanyRepository;

	@Transactional
	public Company addCompany(Company Company) {
		return CompanyRepository.save(Company);
	}

	@Transactional(readOnly = true)
	public List<Company> allCompany() {
		
		return CompanyRepository.findAll();
	}

	@Transactional
	public Company updateCompany(Company Company) {
		return CompanyRepository.save(Company);
	}

	@Transactional
	public void deleteCompany(Company Company) {
		CompanyRepository.delete(Company);
		
	}

	@Transactional(readOnly = true)
	public Company findCompanyById(Long id_Company) {
		return CompanyRepository.findById(id_Company).get();
	}

	@Transactional(readOnly = true)
	public Company getCompanyByTenantId(long tenant_id) {
		return CompanyRepository.getCompanyByTenantId(tenant_id);
	}
}
