package com.restau.localisationRes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.restau.localisationRes.entities.Restaurant;
import com.restau.localisationRes.entities.Zone;
import com.restau.localisationRes.repositories.ZoneRepository;
import com.restau.localisationRes.services.RestaurantService;
import com.restau.localisationRes.services.ZoneService;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/zones")
public class ZoneController {

	@Autowired(required=true)
	private ZoneService zoneService;


	@PostMapping("/save")
	public void save(@RequestBody Zone serie) {
		zoneService.save(serie);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(required = true) String id) {
		Zone s = zoneService.findById(Integer.parseInt(id));
		zoneService.delete(s);
	}

	@GetMapping("/all")
	public List<Zone> findAll() {
		return zoneService.findAll();
	}

	//@GetMapping(value = "/count")
	//public long countZone() {
	//	return zoneService.count();
	//}

	@GetMapping("/{id}")
	public Zone findById(@PathVariable int id) {
		return zoneService.findById(id);
	}
	
	
	/*
	@GetMapping("/byFilliere/{id}")
	public List<Zone> findZonesByVille(@PathVariable int id) {
		return zoneRepository.findByVilleId(id);

	}

	*/
	
}
