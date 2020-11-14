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
import org.springframework.web.bind.annotation.RestController;

import com.GestionStock.app.model.Quotation;
import com.GestionStock.app.service.QuotationService;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/quotations")
public class QuotationController {

	@Autowired
	private QuotationService QuotationService;
	
	@GetMapping("/GetAllQuotations")
	public List<Quotation> GetAllQuotations()
	{
		return QuotationService.allQuotation();
	}
	
	@PostMapping("/addQuotation")
	public Quotation addQuotation(@RequestBody Quotation Quotation) {
		
		return QuotationService.addQuotation(Quotation);
	}
	@GetMapping("/GetAllQuotationByClient/{client}")
	public List<Quotation> GetAllQuotationByClient(@PathVariable long client) {
		
		return QuotationService.getQuotationsByClients(client);
	}
	@PutMapping("/ModQuotation")
	public Quotation ModQuotation(@RequestBody Quotation Quotation) {
		
		return QuotationService.updateQuotation(Quotation);
	}
	@GetMapping("/{id}")
	public Quotation GetQuotationByid(@PathVariable long id) {
		return QuotationService.findQuotationById(id);
	}
	@GetMapping("/GetAllQuotations/{id}")
	public List<Quotation> GetQuotationByTenantId(@PathVariable long id) {
		return QuotationService.getQuotationsByTenantId(id);
	}
	@DeleteMapping("/DelQuotation/{Quotation}")
	public void DelAscenseur(@PathVariable long Quotation) {
		
		QuotationService.deleteQuotation(Quotation);
			//return "Devis Supprimé";
	}
}
