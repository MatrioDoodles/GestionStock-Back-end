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

import com.GestionStock.app.model.Supplier;
import com.GestionStock.app.service.SupplierService;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/suppliers")
public class SupplierController {

	@Autowired
	private SupplierService SupplierService;
	
	
	
	@GetMapping("/GetAllSuppliers")
	public List<Supplier> GetAllSuppliers()
	{
		return SupplierService.allSupplier();
	}
	
	@PostMapping("/addSupplier")
	public Supplier addSupplier(@RequestBody Supplier Supplier) {
		
		return SupplierService.addSupplier(Supplier);
	}
	@PostMapping(value = "/upload", consumes = "multipart/form-data")
	public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file,@RequestParam("id") long id) {
		
		String message = "";
	    try {
	    	SupplierService.save(file,id);

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
		Resource file = SupplierService.load(id);
	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
	}
	@PutMapping("/ModSupplier")
	public Supplier ModSupplier(@RequestBody Supplier Supplier) {
		
		return SupplierService.updateSupplier(Supplier);
	}
	@GetMapping("/{id}")
	public Supplier GetSupplierByid(@PathVariable long id) {
		return SupplierService.findSupplierById(id);
	}

	@GetMapping("/GetAllSuppliersT/{id}")
	public List<Supplier> GetSupplierByTenantId(@PathVariable long id) {
		return SupplierService.getSuppliersByTenantId(id);
	}
	@DeleteMapping("/DelSupplier/{Supplier}")
	public void DelAscenseur(@PathVariable long Supplier) {
		
		SupplierService.deleteSupplier(Supplier);
			//return "Fournisseur Supprimé";
	}
}
