package com.GestionStock.app.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.GestionStock.app.model.Subscription;

@Component
public interface SubscriptionService {

	public Subscription addSubscription(Subscription Subscription);
	public Subscription updateSubscription(Subscription Subscription);
	public void deleteSubscription(long Subscription);
	public Subscription findSubscriptionById(long id_Subscription);
	public List<Subscription> allSubscription();
	public Subscription getSubscriptionsByTenantId(long tenant_id);
}
