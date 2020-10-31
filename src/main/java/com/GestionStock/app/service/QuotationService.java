package com.GestionStock.app.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.GestionStock.app.model.Client;
import com.GestionStock.app.model.Quotation;


@Component
public interface QuotationService {

	public Quotation addQuotation(Quotation Quotation);
	public Quotation updateQuotation(Quotation Quotation);
	public void deleteQuotation(Quotation Quotation);
	public Quotation findQuotationById(Long id_Quotation);
	public List<Quotation> allQuotation();
	public List<Quotation> getQuotationsByTenantId(long tenant_id);
	public long nbQuotationsByTenantId(long tenant_id);
	public List<Quotation> getQuotationsByClients(Client client);
}
