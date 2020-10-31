package com.GestionStock.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GestionStock.app.model.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}
