package com.GestionStock.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.GestionStock.app.model.Company;
import com.GestionStock.app.service.CompanyService;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/companies")
public class CompanyController {

	@Autowired
	private CompanyService CompanyService;
	
	@GetMapping("/GetAllCompanys")
	public List<Company> GetAllCompanys()
	{
		return CompanyService.allCompany();
	}
	
	@PostMapping("/addCompany")
	public Company addCompany(@RequestBody Company Company) {
		
		return CompanyService.addCompany(Company);
	}
	@PutMapping("/ModCompany")
	public Company ModCompany(@RequestBody Company Company) {
		
		return CompanyService.updateCompany(Company);
	}
	@GetMapping("/{id}")
	public Company GetCompanyByid(@PathVariable long id) {
		return CompanyService.findCompanyById(id);
	}
	
	@GetMapping("/Company/{id}")
	public Company GetCompanyByTenantId(@PathVariable long id) {
		return CompanyService.getCompanyByTenantId(id);
	}

	@DeleteMapping("/DelCompany")
	@ResponseBody
	public String DelAscenseur(@RequestBody Company Company) {
		
		CompanyService.deleteCompany(Company);
			return "Entreprise Supprimé";
	}
}
