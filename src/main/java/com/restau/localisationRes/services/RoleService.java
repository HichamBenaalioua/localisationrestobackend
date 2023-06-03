package com.restau.localisationRes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restau.localisationRes.dao.IDao;
import com.restau.localisationRes.entities.Role;
import com.restau.localisationRes.repositories.RoleRepository;

@Service
public class RoleService implements IDao<Role> {

	@Autowired(required = true)
	private RoleRepository roleRepository;

	@Override
	public void save(Role o) {
		roleRepository.save(o);

	}

	@Override
	public void delete(Role o) {
		roleRepository.delete(o);

	}

	@Override
	public void update(Role o) {
		roleRepository.save(o);

	}

	@Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	@Override
	public Role findById(int id) {
		return roleRepository.findById(id);
	}


}