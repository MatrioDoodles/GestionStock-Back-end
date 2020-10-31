package com.GestionStock.app.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.GestionStock.app.model.Client;

@Component
public interface ClientService {

	public Client addClient(Client Client);
	public Client updateClient(Client Client);
	public void deleteClient(Client Client);
	public Client findClientById(Long id_Client);
	public List<Client> allClient();
	public List<Client> getClientsByTenantId(long tenant_id);
	public long nbClientsByTenantId(long tenant_id);
}
