package com.GestionStock.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.GestionStock.app.model.User;
import com.GestionStock.app.repository.UserRepository;
import com.GestionStock.app.service.UserService;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Transactional
	public User addUser(User user) {
		return userRepository.save(user);
	}

	@Transactional(readOnly = true)
	public List<User> allUser() {
		
		return userRepository.findAll();
	}

	@Transactional
	public User updateUser(User user) {
		return userRepository.save(user);
	}

	@Transactional
	public void deleteUser(User user) {
		userRepository.delete(user);
		
	}

	@Transactional(readOnly = true)
	public User findUserById(Long id_user) {
		return userRepository.findById(id_user).get();
	}

	@Transactional(readOnly = true)
	public List<User> getUsersByTenantId(User tenant) {
		return userRepository.findBytenant(tenant);
	}

	@Transactional(readOnly = true)
	public long nbUsersByTenantId(User tenant) {
		return userRepository.findBytenant(tenant).size();
	}

	@Override
	public User findUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByusername(username);
	}
	
	

}
