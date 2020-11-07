package com.GestionStock.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GestionStock.app.model.Subscription;
import com.GestionStock.app.service.SubscriptionService;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/subscriptions")
public class SubscriptionController {
	@Autowired
	private SubscriptionService SubscriptionService;
	
	@GetMapping("/GetAllSubscriptions")
	public List<Subscription> GetAllSubscriptions()
	{
		return SubscriptionService.allSubscription();
	}
	
	@PostMapping("/addSubscription")
	public Subscription addSubscription(@RequestBody Subscription Subscription) {
		
		return SubscriptionService.addSubscription(Subscription);
	}
	@PostMapping("/ModSubscription")
	public Subscription ModSubscription(@RequestBody Subscription Subscription) {
		
		return SubscriptionService.updateSubscription(Subscription);
	}
	@GetMapping("/{id}")
	public Subscription GetSubscriptionByid(@PathVariable long id) {
		return SubscriptionService.findSubscriptionById(id);
	}
	@GetMapping("/GetSubscriptionT/{id}")
	public Subscription GetSubscriptionByTenantId(@PathVariable long id) {
		return SubscriptionService.getSubscriptionsByTenantId(id);
	}

	@DeleteMapping("/DelSubscription")
	public void DelAscenseur(@RequestBody Subscription Subscription) {
		
		SubscriptionService.deleteSubscription(Subscription);
			//return "Abonnement Supprimé";
	}
}
