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

import com.GestionStock.app.model.Client;
import com.GestionStock.app.model.Invoice;
import com.GestionStock.app.model.Order;
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
	@PostMapping("/InvoiceByClient")
	public List<Invoice> GetInvoiceByClient(@RequestBody Client client) {
		
		return InvoiceService.getInvoicesClient(client);
	}
	@PostMapping("/InvoiceByOrder")
	public Invoice GetInvoiceByOrde(@RequestBody Order order) {
		
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

	@DeleteMapping("/DelInvoice")
	@ResponseBody
	public String DelAscenseur(@RequestBody Invoice Invoice) {
		
		InvoiceService.deleteInvoice(Invoice);
			return "Facture Supprimé";
	}
}
