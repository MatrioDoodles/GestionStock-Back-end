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
import com.GestionStock.app.model.Order;
import com.GestionStock.app.service.OrderService;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/orders")
public class OrderController {

	@Autowired
	private OrderService OrderService;
	
	@GetMapping("/GetAllOrders")
	public List<Order> GetAllOrders()
	{
		return OrderService.allOrder();
	}
	
	@PostMapping("/addOrder")
	public Order addOrder(@RequestBody Order Order) {
		
		return OrderService.addOrder(Order);
	}
	@PostMapping("/GetOrdersByClient")
	public List<Order> GetOrdersByClient(@RequestBody Client client) {
		
		return OrderService.getOrdersByClient(client);
	}
	@PutMapping("/ModOrder")
	public Order ModOrder(@RequestBody Order Order) {
		
		return OrderService.updateOrder(Order);
	}
	@GetMapping("/{id}")
	public Order GetOrderByid(@PathVariable long id) {
		return OrderService.findOrderById(id);
	}
	@GetMapping("/GetAllOrdersT/{id}")
	public List<Order> GetOrderByTenantId(@PathVariable long id) {
		return OrderService.getOrdersByTenantId(id);
	}

	@DeleteMapping("/DelOrder")
	@ResponseBody
	public String DelAscenseur(@RequestBody Order Order) {
		
		OrderService.deleteOrder(Order);
			return "Commande Supprimé";
	}
}
