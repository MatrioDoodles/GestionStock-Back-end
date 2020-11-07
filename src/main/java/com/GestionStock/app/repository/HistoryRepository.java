package com.GestionStock.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.GestionStock.app.model.History;

@Repository
public interface HistoryRepository  extends JpaRepository<History, Long> {
	
	public List<History> findBytenantid(long tenant_id);

}
