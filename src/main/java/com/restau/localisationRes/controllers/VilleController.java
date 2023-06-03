package com.restau.localisationRes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.restau.localisationRes.entities.Restaurant;
import com.restau.localisationRes.entities.Ville;
import com.restau.localisationRes.entities.Zone;
import com.restau.localisationRes.services.VilleService;
import com.restau.localisationRes.services.ZoneService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/villes")
public class VilleController {
	
	@Autowired
	private VilleService villeService;
	private ZoneService zoneService;

	@PostMapping("/save")
	public void save(@RequestBody Ville serie) {
		villeService.save(serie);
	}
	@CrossOrigin
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(required = true) String id) {
		Ville s = villeService.findById(Integer.parseInt(id));
		villeService.delete(s);
	}

	@GetMapping("/all")
	public List<Ville> findAll() {
		return villeService.findAll();
	}



	@GetMapping("/{id}")
	public Ville findById(@PathVariable int id) {
		return villeService.findById(id);
	}

	@GetMapping("/{idVille}/zones")
	public List<Zone> getZonesForVille(@PathVariable int idVille) throws Exception {
		Ville ville = villeService.findById(idVille);
		if (ville == null) {
			throw new Exception("La ville avec le nom " + idVille + " n'existe pas.");
		}
		return ville.getZones();
	}
	/*
	@GetMapping("/villes/{nomVille}/zones/{nomZone}/restaurants")
	public ResponseEntity<List<Restaurant>> getAllRestaurantsForZone(
	        @PathVariable String nomVille, @PathVariable String nomZone) {
	    Ville ville = villeService.findByNom(nomVille);
	    if (ville == null) {
	        return ResponseEntity.notFound().build();
	    }
	    Zone zone = ville.getZones().stream()
	            .filter(z -> z.getNom().equals(nomZone))
	            .findFirst().orElse(null);
	    if (zone == null) {
	        return ResponseEntity.notFound().build();
	    }
	    List<Restaurant> restaurants = zone.getRestaurants();
	    return ResponseEntity.ok().body(restaurants);
	}

	
	@GetMapping("/villes/{nomVille}/zones/{nomZone}/restaurants")
	public List<Restaurant> getRestaurantsByZone(@PathVariable String nomVille, @PathVariable String nomZone) {
	    Ville ville = villeService.findByNom(nomVille);
	    Zone zone = zoneService.findByNomAndVille(nomZone, ville);
	    return zone.getRestaurants();
	}
*/

}
