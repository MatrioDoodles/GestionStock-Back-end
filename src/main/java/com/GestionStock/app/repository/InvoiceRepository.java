package com.GestionStock.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GestionStock.app.model.Client;
import com.GestionStock.app.model.Invoice;
import com.GestionStock.app.model.Order;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

	public List<Invoice> findBytenantid(long tenant_id);
	public List<Invoice> findByclient(Client client);
	public Invoice findByorder(Order order);
}
