package com.GestionStock.app.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.GestionStock.app.model.Order;


@Component
public interface OrderService {

	public Order addOrder(Order Order);
	public Order updateOrder(Order Order);
	public void deleteOrder(long Order);
	public Order findOrderById(long id_Order);
	public List<Order> allOrder();
	public List<Order> getOrdersByTenantId(long tenant_id);
	public long nbOrdersByTenantId(long tenant_id);
	public List<Order> getOrdersByClient(long client);
}
