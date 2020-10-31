package com.GestionStock.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.GestionStock.app.model.Client;
import com.GestionStock.app.model.Invoice;
import com.GestionStock.app.model.Order;
import com.GestionStock.app.repository.InvoiceRepository;
import com.GestionStock.app.service.InvoiceService;

@Service("InvoiceServiceImpl")
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	private InvoiceRepository InvoiceRepository;

	@Transactional
	public Invoice addInvoice(Invoice Invoice) {
		return InvoiceRepository.save(Invoice);
	}

	@Transactional(readOnly = true)
	public List<Invoice> allInvoice() {
		
		return InvoiceRepository.findAll();
	}

	@Transactional
	public Invoice updateInvoice(Invoice Invoice) {
		return InvoiceRepository.save(Invoice);
	}

	@Transactional
	public void deleteInvoice(Invoice Invoice) {
		InvoiceRepository.delete(Invoice);
		
	}

	@Transactional(readOnly = true)
	public Invoice findInvoiceById(Long id_Invoice) {
		return InvoiceRepository.findById(id_Invoice).get();
	}

	@Transactional(readOnly = true)
	public List<Invoice> getInvoicesByTenantId(long tenant_id) {
		return InvoiceRepository.getInvoicesByTenantId(tenant_id);
	}

	@Transactional(readOnly = true)
	public long nbInvoicesByTenantId(long tenant_id) {
		return InvoiceRepository.getInvoicesByTenantId(tenant_id).size();
	}

	@Transactional(readOnly = true)
	public List<Invoice> getInvoicesClient(Client client) {
		return InvoiceRepository.getInvoicesClient(client);
	}

	@Transactional(readOnly = true)
	public Invoice getInvoiceByOrder(Order order) {
		return InvoiceRepository.getInvoiceByOrder(order);
	}
}
