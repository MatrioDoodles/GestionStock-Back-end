package com.GestionStock.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GestionStock.app.model.Client;
import com.GestionStock.app.model.Quotation;


@Repository
public interface QuotationRepository extends JpaRepository<Quotation, Long> {

	public List<Quotation> findBytenantid(long tenant_id);
	public List<Quotation> findByclient(Client client);
}
