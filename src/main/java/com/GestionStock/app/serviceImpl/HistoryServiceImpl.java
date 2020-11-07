package com.GestionStock.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.GestionStock.app.model.History;
import com.GestionStock.app.repository.HistoryRepository;
import com.GestionStock.app.service.HistoryService;

@Service("HistoryServiceImpl")
public class HistoryServiceImpl implements HistoryService{
	@Autowired
	private HistoryRepository historyRepository;
	
	@Transactional
	public History addHistory(History History) {
		return historyRepository.save(History);
	}

	@Transactional
	public History updateHistory(History History) {
		return historyRepository.save(History);
	}

	@Transactional
	public void deleteHistory(History History) {

		historyRepository.delete(History);
	}

	@Transactional(readOnly = true)
	public History findHistoryById(Long id_History) {
		return historyRepository.findById(id_History).get();
	}

	@Transactional(readOnly = true)
	public List<History> allHistory() {
		return historyRepository.findAll();
	}

	@Transactional(readOnly = true)
	public List<History> getHistoryByTenantId(long tenant_id) {
		return historyRepository.findBytenantid(tenant_id);
	}

}
