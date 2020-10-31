package com.GestionStock.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GestionStock.app.model.Client;
import com.GestionStock.app.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

	public List<Order> getOrdersByTenantId(long tenant_id);
	public List<Order> getOrdersByClient(Client client);
}
