package com.GestionStock.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.GestionStock.app.model.Subscription;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

	public Subscription getSubscriptionsByTenantId(long tenant_id);
}
