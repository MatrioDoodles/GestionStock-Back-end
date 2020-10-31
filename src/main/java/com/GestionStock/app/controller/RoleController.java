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

import com.GestionStock.app.model.Role;
import com.GestionStock.app.service.RoleService;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/roles")
public class RoleController {
	@Autowired
	private RoleService RoleService;
	
	@GetMapping("/GetAllRoles")
	public List<Role> GetAllRoles()
	{
		return RoleService.allRole();
	}
	
	@PostMapping("/addRole")
	public Role addRole(@RequestBody Role Role) {
		
		return RoleService.addRole(Role);
	}
	@PutMapping("/ModRole")
	public Role ModRole(@RequestBody Role Role) {
		
		return RoleService.updateRole(Role);
	}
	@GetMapping("/{id}")
	public Role GetRoleByid(@PathVariable long id) {
		return RoleService.findRoleById(id);
	}

	@DeleteMapping("/DelRole")
	@ResponseBody
	public String DelAscenseur(@RequestBody Role Role) {
		
		RoleService.deleteRole(Role);
			return "Role Supprimé";
	}
}
