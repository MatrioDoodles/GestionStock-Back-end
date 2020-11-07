package com.GestionStock.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.GestionStock.app.model.Client;
import com.GestionStock.app.repository.ClientRepository;
import com.GestionStock.app.service.ClientService;

@Service("ClientServiceImpl")
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository ClientRepository;

	@Transactional
	public Client addClient(Client Client) {
		return ClientRepository.save(Client);
	}

	@Transactional(readOnly = true)
	public List<Client> allClient() {
		
		return ClientRepository.findAll();
	}

	@Transactional
	public Client updateClient(Client Client) {
		return ClientRepository.save(Client);
	}

	@Transactional
	public void deleteClient(long id) {
		ClientRepository.deleteById(id);
		
	}

	@Transactional(readOnly = true)
	public Client findClientById(Long id_Client) {
		return ClientRepository.findById(id_Client).get();
	}

	@Transactional(readOnly = true)
	public List<Client> getClientsByTenantId(long tenant_id) {
		return ClientRepository.findBytenantid(tenant_id);
	}

	@Transactional(readOnly = true)
	public long nbClientsByTenantId(long tenant_id) {
		return ClientRepository.findBytenantid(tenant_id).size();
	}
}
