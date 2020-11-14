package com.GestionStock.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.GestionStock.app.model.Quotation;
import com.GestionStock.app.repository.QuotationRepository;
import com.GestionStock.app.service.QuotationService;

@Service("QuotationServiceImpl")
public class QuotationServiceImpl implements QuotationService {

	@Autowired
	private QuotationRepository QuotationRepository;

	@Transactional
	public Quotation addQuotation(Quotation Quotation) {
		return QuotationRepository.save(Quotation);
	}

	@Transactional(readOnly = true)
	public List<Quotation> allQuotation() {
		
		return QuotationRepository.findAll();
	}

	@Transactional
	public Quotation updateQuotation(Quotation Quotation) {
		return QuotationRepository.save(Quotation);
	}

	@Transactional
	public void deleteQuotation(long Quotation) {
		QuotationRepository.deleteById(Quotation);
		
	}

	@Transactional(readOnly = true)
	public Quotation findQuotationById(long id_Quotation) {
		return QuotationRepository.findById(id_Quotation).get();
	}

	@Transactional(readOnly = true)
	public List<Quotation> getQuotationsByTenantId(long tenant_id) {
		return QuotationRepository.findBytenantid(tenant_id);
	}

	@Transactional(readOnly = true)
	public long nbQuotationsByTenantId(long tenant_id) {
		return QuotationRepository.findBytenantid(tenant_id).size();
	}

	@Transactional(readOnly = true)
	public List<Quotation> getQuotationsByClients(long client) {
		return QuotationRepository.findByclient_Id(client);
	}
}
