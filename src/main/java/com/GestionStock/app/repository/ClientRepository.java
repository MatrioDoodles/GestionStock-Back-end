package com.GestionStock.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.GestionStock.app.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

	public List<Client> getClientsByTenantId(long tenant_id);
}
