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

import com.GestionStock.app.model.History;
import com.GestionStock.app.service.HistoryService;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/history")
public class HistoryController {

	
	@Autowired
	private HistoryService HistoryService;
	
	@GetMapping("/GetAllHistorys")
	public List<History> GetAllHistorys()
	{
		return HistoryService.allHistory();
	}
	@GetMapping("/GetAllHistorysT/{id}")
	public List<History> GetAllHistorysbyTenantId(@PathVariable long id)
	{
		return HistoryService.getHistoryByTenantId(id);
	}
	
	@PostMapping("/addHistory")
	public History addHistory(@RequestBody History History) {
		
		return HistoryService.addHistory(History);
	}
	@PutMapping("/ModHistory")
	public History ModHistory(@RequestBody History History) {
		
		return HistoryService.updateHistory(History);
	}
	@GetMapping("/{id}")
	public History GetHistoryByid(@PathVariable long id) {
		return HistoryService.findHistoryById(id);
	}

	@DeleteMapping("/DelHistory")
	@ResponseBody
	public String DelAscenseur(@RequestBody History History) {
		
		HistoryService.deleteHistory(History);
			return "Historique Supprimé";
	}
}
