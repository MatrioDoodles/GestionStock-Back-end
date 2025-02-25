package com.GestionStock.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.GestionStock.app.model.Order;
import com.GestionStock.app.repository.OrderRepository;
import com.GestionStock.app.service.OrderService;

@Service("OrderServiceImpl")
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepository OrderRepository;

	@Transactional
	public Order addOrder(Order Order) {
		return OrderRepository.save(Order);
	}

	@Transactional(readOnly = true)
	public List<Order> allOrder() {
		
		return OrderRepository.findAll();
	}

	@Transactional
	public Order updateOrder(Order Order) {
		return OrderRepository.save(Order);
	}

	@Transactional
	public void deleteOrder(long Order) {
		OrderRepository.deleteById(Order);
		
	}

	@Transactional(readOnly = true)
	public Order findOrderById(long id_Order) {
		return OrderRepository.findById(id_Order).get();
	}

	@Transactional(readOnly = true)
	public List<Order> getOrdersByTenantId(long tenant_id) {
		return OrderRepository.findBytenantid(tenant_id);
	}

	@Transactional(readOnly = true)
	public long nbOrdersByTenantId(long tenant_id) {
		return OrderRepository.findBytenantid(tenant_id).size();
	}

	@Transactional(readOnly = true)
	public List<Order> getOrdersByClient(long client) {
		return OrderRepository.findByclient_Id(client);
	}
}
