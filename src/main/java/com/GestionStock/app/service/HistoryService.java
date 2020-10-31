package com.GestionStock.app.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.GestionStock.app.model.History;

@Component
public interface HistoryService {
	
	public History addHistory(History History);
	public History updateHistory(History History);
	public void deleteHistory(History History);
	public History findHistoryById(Long id_History);
	public List<History> allHistory();
	public List<History> getHistoryByTenantId(long tenant_id);
}
