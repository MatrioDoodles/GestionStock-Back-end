package com.GestionStock.app.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.GestionStock.app.model.Client;
import com.GestionStock.app.model.Invoice;
import com.GestionStock.app.model.Order;


@Component
public interface InvoiceService {

	public Invoice addInvoice(Invoice Invoice);
	public Invoice updateInvoice(Invoice Invoice);
	public void deleteInvoice(Invoice Invoice);
	public Invoice findInvoiceById(Long id_Invoice);
	public List<Invoice> allInvoice();
	public List<Invoice> getInvoicesByTenantId(long tenant_id);
	public long nbInvoicesByTenantId(long tenant_id);
	public List<Invoice> getInvoicesClient(Client client);
	public Invoice getInvoiceByOrder(Order order);
}
