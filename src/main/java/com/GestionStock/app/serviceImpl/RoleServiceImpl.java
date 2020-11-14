package com.GestionStock.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.GestionStock.app.model.Role;
import com.GestionStock.app.repository.RoleRepository;
import com.GestionStock.app.service.RoleService;

@Service("RoleServiceImpl")
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleRepository RoleRepository;

	@Transactional
	public Role addRole(Role Role) {
		return RoleRepository.save(Role);
	}

	@Transactional(readOnly = true)
	public List<Role> allRole() {
		
		return RoleRepository.findAll();
	}

	@Transactional
	public Role updateRole(Role Role) {
		return RoleRepository.save(Role);
	}

	@Transactional
	public void deleteRole(long Role) {
		RoleRepository.deleteById(Role);
		
	}

	@Transactional(readOnly = true)
	public Role findRoleById(long id_Role) {
		return RoleRepository.findById(id_Role).get();
	}
}
