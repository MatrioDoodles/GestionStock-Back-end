package com.GestionStock.app.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.GestionStock.app.model.Invoice;


@Component
public interface InvoiceService {

	public Invoice addInvoice(Invoice Invoice);
	public Invoice updateInvoice(Invoice Invoice);
	public void deleteInvoice(long Invoice);
	public Invoice findInvoiceById(long id_Invoice);
	public List<Invoice> allInvoice();
	public List<Invoice> getInvoicesByTenantId(long tenant_id);
	public long nbInvoicesByTenantId(long tenant_id);
	public List<Invoice> getInvoicesClient(long client);
	public Invoice getInvoiceByOrder(long order);
}
