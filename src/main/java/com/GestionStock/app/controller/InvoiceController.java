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

import com.GestionStock.app.model.Invoice;
import com.GestionStock.app.service.InvoiceService;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/invoices")
public class InvoiceController {

	@Autowired
	private InvoiceService InvoiceService;
	
	@GetMapping("/GetAllInvoices")
	public List<Invoice> GetAllInvoices()
	{
		return InvoiceService.allInvoice();
	}
	
	@PostMapping("/addInvoice")
	public Invoice addInvoice(@RequestBody Invoice Invoice) {
		
		return InvoiceService.addInvoice(Invoice);
	}
	@GetMapping("/InvoiceByClient/{client}")
	public List<Invoice> GetInvoiceByClient(@PathVariable long client) {
		
		return InvoiceService.getInvoicesClient(client);
	}
	@GetMapping("/InvoiceByOrder/{order}")
	public Invoice GetInvoiceByOrde(@PathVariable long order) {
		
		return InvoiceService.getInvoiceByOrder(order);
	}
	@PutMapping("/ModInvoice")
	public Invoice ModInvoice(@RequestBody Invoice Invoice) {
		
		return InvoiceService.updateInvoice(Invoice);
	}
	@GetMapping("/{id}")
	public Invoice GetInvoiceByid(@PathVariable long id) {
		return InvoiceService.findInvoiceById(id);
	}
	@GetMapping("/GetAllInvoicesT/{id}")
	public List<Invoice> GetInvoiceByTenantId(@PathVariable long id) {
		return InvoiceService.getInvoicesByTenantId(id);
	}

	@DeleteMapping("/DelInvoice/{Invoice}")
	public void DelAscenseur(@PathVariable long Invoice) {
		
		InvoiceService.deleteInvoice(Invoice);
			//return "Facture Supprimé";
	}
}
