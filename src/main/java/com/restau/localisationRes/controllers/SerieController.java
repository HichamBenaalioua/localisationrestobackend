package com.restau.localisationRes.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
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

import com.restau.localisationRes.entities.Photo;
import com.restau.localisationRes.entities.Serie;
import com.restau.localisationRes.repositories.PhotoRepository;
import com.restau.localisationRes.services.SerieService;

import jakarta.validation.Valid;


@CrossOrigin
@RestController
@RequestMapping("/series")
public class SerieController {
	@Autowired
	private SerieService serieService;

	@PostMapping("/save")
	public void save(@RequestBody Serie serie) {
		serieService.save(serie);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(required = true) String id) {
		Serie s = serieService.findById(Integer.parseInt(id));
		serieService.delete(s);
	}

	@GetMapping("/all")
	public List<Serie> findAll() {
		return serieService.findAll();
	}


	@GetMapping("/{id}")
	public Serie findById(@PathVariable int id) {
		return serieService.findById(id);
	}
}
