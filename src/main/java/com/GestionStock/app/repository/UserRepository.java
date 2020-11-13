package com.GestionStock.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.GestionStock.app.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public List<User> findBytenant_Id(long tenant);
	public User findByusername(String username);
}
