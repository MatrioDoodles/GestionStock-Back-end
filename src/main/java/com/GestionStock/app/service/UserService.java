package com.GestionStock.app.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.GestionStock.app.model.User;


@Component
public interface UserService {

	public User addUser(User user);
	public User updateUser(User user);
	public void deleteUser(long user);
	public User findUserById(long id_user);
	public User findUserByUsername(String username);
	public List<User> allUser();
	public List<User> getUsersByTenantId(long tenant);
	public long nbUsersByTenantId(long tenant);
}
