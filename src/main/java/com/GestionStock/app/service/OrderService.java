package com.GestionStock.app.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.GestionStock.app.model.Client;
import com.GestionStock.app.model.Order;


@Component
public interface OrderService {

	public Order addOrder(Order Order);
	public Order updateOrder(Order Order);
	public void deleteOrder(Order Order);
	public Order findOrderById(Long id_Order);
	public List<Order> allOrder();
	public List<Order> getOrdersByTenantId(long tenant_id);
	public long nbOrdersByTenantId(long tenant_id);
	public List<Order> getOrdersByClient(Client client);
}
