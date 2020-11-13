package com.GestionStock.app.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.GestionStock.app.model.Role;


@Component
public interface RoleService {

	public Role addRole(Role Role);
	public Role updateRole(Role Role);
	public void deleteRole(Role Role);
	public Role findRoleById(long id_Role);
	public List<Role> allRole();
}
