package com.GestionStock.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.GestionStock.app.model.Client;
import com.GestionStock.app.service.ClientService;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/clients")
public class ClientController {

	@Autowired
	private ClientService ClientService;
	
	@GetMapping("/GetAllClients")
	public List<Client> GetAllClients()
	{
		return ClientService.allClient();
	}
	@GetMapping("/GetAllClientsT/{id}")
	public List<Client> GetAllClientsbyTenantId(@PathVariable long id)
	{
		return ClientService.getClientsByTenantId(id);
	}
	
	@PostMapping("/addClient")
	public Client addClient(@RequestBody Client Client) {
		
		return ClientService.addClient(Client);
	}
	@PutMapping("/ModClient")
	public Client ModClient(@RequestBody Client Client) {
		
		return ClientService.updateClient(Client);
	}
	@GetMapping("/{id}")
	public Client GetClientByid(@PathVariable long id) {
		return ClientService.findClientById(id);
	}

	@DeleteMapping("/DelClient")
	@ResponseBody
	public String DelAscenseur(@RequestBody Client Client) {
		
		ClientService.deleteClient(Client);
			return "Client Supprimé";
	}
}
