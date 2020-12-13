package com.GestionStock.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
	
	@PostMapping("/upload")
	public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file,@RequestParam("id") long id) {
		
		String message = "";
	    try {
	    	CompanyService.save(file,id);

	      message = "Uploaded the file successfully: " + file.getOriginalFilename();
	      return ResponseEntity.status(HttpStatus.OK).body(message);
	    } catch (Exception e) {
	      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
	    }
	}
	@GetMapping("/img/{id}")	
	@ResponseBody
	public ResponseEntity<Resource> getimg(@PathVariable long id)
	{   
		Resource file = CompanyService.load(id);
	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
	}
	@GetMapping("/Company/{id}")
	public Company GetCompanyByTenantId(@PathVariable long id) {
		return CompanyService.getCompanyByTenantId(id);
	}

	@DeleteMapping("/DelCompany/{Company}")
	public void DelAscenseur(@PathVariable long Company) {
		
		CompanyService.deleteCompany(Company);
			//return "Entreprise Supprimé";
	}
}
