package com.GestionStock.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.GestionStock.app.model.Subscription;
import com.GestionStock.app.repository.SubscriptionRepository;
import com.GestionStock.app.service.SubscriptionService;


@Service("SubscriptionServiceImpl")
public class SubscriptionServiceImpl  implements SubscriptionService{

	@Autowired
	private SubscriptionRepository SubscriptionRepository;

	@Transactional
	public Subscription addSubscription(Subscription Subscription) {
		return SubscriptionRepository.save(Subscription);
	}

	@Transactional(readOnly = true)
	public List<Subscription> allSubscription() {
		
		return SubscriptionRepository.findAll();
	}

	@Transactional
	public Subscription updateSubscription(Subscription Subscription) {
		return SubscriptionRepository.save(Subscription);
	}

	@Transactional
	public void deleteSubscription(long Subscription) {
		SubscriptionRepository.deleteById(Subscription);
		
	}

	@Transactional(readOnly = true)
	public Subscription findSubscriptionById(long id_Subscription) {
		return SubscriptionRepository.findById(id_Subscription).get();
	}

	@Transactional(readOnly = true)
	public Subscription getSubscriptionsByTenantId(long tenant_id) {
		return SubscriptionRepository.findBytenantid(tenant_id);
	}
}
