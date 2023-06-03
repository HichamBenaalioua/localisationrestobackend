package com.restau.localisationRes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restau.localisationRes.entities.Role;
import com.restau.localisationRes.services.RoleService;


@RestController
@RequestMapping("/roles")
public class RoleController {
	@Autowired
	private RoleService roleService;

	@PostMapping("/save")
	public void save(@RequestBody Role role) {
		roleService.save(role);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(required = true) String id) {
		Role s = roleService.findById(Integer.parseInt(id));
		roleService.delete(s);
	}

	@GetMapping("/all")
	public List<Role> findAll() {
		return roleService.findAll();
	}


	@GetMapping("/{id}")
	public Role findById(@PathVariable int id) {
		return roleService.findById(id);
	}
}
