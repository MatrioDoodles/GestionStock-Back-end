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

import com.GestionStock.app.model.Warehouse;
import com.GestionStock.app.service.WarehouseService;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/warehouses")
public class WarehouseController {

	@Autowired
	private WarehouseService WarehouseService;
	
	@GetMapping("/GetAllWarehouses")
	public List<Warehouse> GetAllWarehouses()
	{
		return WarehouseService.allWarehouse();
	}
	
	@PostMapping("/addWarehouse")
	public Warehouse addWarehouse(@RequestBody Warehouse Warehouse) {
		
		return WarehouseService.addWarehouse(Warehouse);
	}
	@PostMapping("/ModWarehouse")
	public Warehouse ModWarehouse(@RequestBody Warehouse Warehouse) {
		
		return WarehouseService.updateWarehouse(Warehouse);
	}
	@GetMapping("/{id}")
	public Warehouse GetWarehouseByid(@PathVariable long id) {
		return WarehouseService.findWarehouseById(id);
	}
	@GetMapping("/GetAllWarehousesT/{id}")
	public List<Warehouse> GetWarehouseByTenantId(@PathVariable long id) {
		return WarehouseService.getWarehousesByTenantId(id);
	}

	@DeleteMapping("/DelWarehouse/{Warehouse}")
	public void DelAscenseur(@PathVariable long Warehouse) {
		
		WarehouseService.deleteWarehouse(Warehouse);
			//return "Entrepot Supprimé";
	}
}
