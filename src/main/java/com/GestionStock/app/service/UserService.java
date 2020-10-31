package com.GestionStock.app.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.GestionStock.app.model.User;


@Component
public interface UserService {

	public User addUser(User user);
	public User updateUser(User user);
	public void deleteUser(User user);
	public User findUserById(Long id_user);
	public List<User> allUser();
	public List<User> getUsersByTenantId(User tenant);
	public long nbUsersByTenantId(User tenant);
}
