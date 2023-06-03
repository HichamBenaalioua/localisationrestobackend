package com.restau.localisationRes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restau.localisationRes.dao.IDao;
import com.restau.localisationRes.entities.User;
import com.restau.localisationRes.repositories.UserRepository;

@Service
public class UserService implements IDao<User> {
	
	@Autowired(required=true)
	private UserRepository userRepository;

	@Override
	public void save(User o) {
		userRepository.save(o);
		
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
		//return null;
	}

	@Override
	public void delete(User o) {
		userRepository.delete(o);
		
	}

	@Override
	public void update(User o) {
		userRepository.save(o);
		
	}

	@Override
	public User findById(int id) {
		return userRepository.findById(id);
	}
	
	public User findByEmailAndPassword(String email,String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}

	
}