package com.restau.localisationRes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.restau.localisationRes.entities.Serie;
import com.restau.localisationRes.entities.Specialite;
import com.restau.localisationRes.repositories.SerieRepository;
import com.restau.localisationRes.services.SpecialiteService;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/specialites")
public class SpecialiteController {

	@Autowired
	private SpecialiteService specialiteService;

	@PostMapping("/save")
	public void save(@RequestBody Specialite serie) {
		specialiteService.save(serie);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(required = true) String id) {
		Specialite s = specialiteService.findById(Integer.parseInt(id));
		specialiteService.delete(s);
	}

	@GetMapping("/all")
	public List<Specialite> findAll() {
		return specialiteService.findAll();
	}

	@GetMapping("/{id}")
	public Specialite findById(@PathVariable int id) {
		return specialiteService.findById(id);
	}
}
