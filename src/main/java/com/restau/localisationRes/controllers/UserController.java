package com.restau.localisationRes.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restau.localisationRes.entities.Specialite;
import com.restau.localisationRes.entities.User;
import com.restau.localisationRes.repositories.SpecialiteRepository;
import com.restau.localisationRes.services.UserService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/users")
public class UserController {


	@Autowired
	private UserService userService;
	
	@CrossOrigin
	@PostMapping("/save")
	public void save(@RequestBody User serie) {
		userService.save(serie);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(required = true) String id) {
		User s = userService.findById(Integer.parseInt(id));
		userService.delete(s);
	}

	@GetMapping("/all")
	public List<User> findAll() {
		return userService.findAll();
	}


	@GetMapping("/{id}")
	public User findById(@PathVariable int id) {
		return userService.findById(id);
	}
	
	@CrossOrigin
	@PostMapping("/login")
	public Map<String, Object> login(@RequestBody Map<String, String> loginData) {
		Map<String, Object> response = new HashMap<>();
		String email = loginData.get("email");
		String password = loginData.get("password");
        User user = userService.findByEmailAndPassword(email, password);
        if (user != null) {
        	response.put("id",user.getId());
        	response.put("role",user.getRoles());
            return response;
        } else {
        	response.put("error","not found");
            return response;
        }
    }
}

