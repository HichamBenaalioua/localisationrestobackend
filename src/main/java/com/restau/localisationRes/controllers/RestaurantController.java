package com.restau.localisationRes.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restau.localisationRes.entities.Photo;
import com.restau.localisationRes.entities.Restaurant;
import com.restau.localisationRes.entities.Ville;
import com.restau.localisationRes.entities.Zone;
import com.restau.localisationRes.repositories.PhotoRepository;
import com.restau.localisationRes.services.PhotoService;
import com.restau.localisationRes.services.RestaurantService;
import com.restau.localisationRes.services.VilleService;
import com.restau.localisationRes.services.ZoneService;

@CrossOrigin
@RestController
@RequestMapping("restaurants")
public class RestaurantController {

	
	@Autowired
	private RestaurantService restaurantService;
	private VilleService villeService;
	private ZoneService zoneService;


	@PostMapping("/save")
	public void save(@RequestBody Restaurant restaurant) {
		
		
	        restaurantService.save(restaurant);
		
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(required = true) String id) {
		Restaurant s = restaurantService.findById(Integer.parseInt(id));
		restaurantService.delete(s);
	}

	@GetMapping("/all")
	public List<Restaurant> findAll() {
		return restaurantService.findAll();
	}


	@GetMapping("/{id}")
	public Restaurant findById(@PathVariable int id) {
		return restaurantService.findById(id);
	}

	@GetMapping("/villes/{nomVille}/zones/{nomZone}/restaurants")
	public List<Restaurant> getRestaurantsByZone(@PathVariable String nomVille, @PathVariable String nomZone) {
	    Ville ville = villeService.findByNom(nomVille);
	    Zone zone = zoneService.findByNomAndVille(nomZone, ville);
	    return zone.getRestaurants();
	}
	
	 @GetMapping("/byZoneId/{zoneId}")
	    public List<Restaurant> getRestaurantsByZoneId(@PathVariable String zoneId) {
	        return restaurantService.getRestaurantsByZoneId(zoneId);
	    }

	/*
	
    private RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    // Récupérer tous les restaurants
    
    @GetMapping
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.findAll();
    }

    // Récupérer un restaurant par son id
    
    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable("id") int id) {
        Optional<Restaurant> restaurant = RestaurantService.findById(id);
        if (restaurant.isPresent()) {
            return new ResponseEntity<>(restaurant.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Ajouter un nouveau restaurant
    
    @PostMapping
    public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant) {
        Restaurant savedRestaurant = restaurantService.save(restaurant);
        return new ResponseEntity<>(savedRestaurant, HttpStatus.CREATED);
    }

    // Mettre à jour un restaurant existant
    
    @PutMapping("/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable("id") int id, @RequestBody Restaurant restaurant) {
        Optional<Restaurant> restaurantData = RestaurantService.findById(id);
        if (restaurantData.isPresent()) {
            Restaurant updatedRestaurant = restaurantData.get();
            updatedRestaurant.setNom(restaurant.getNom());
            updatedRestaurant.setAdresse(restaurant.getAdresse());
            updatedRestaurant.setDescription(restaurant.getDescription());
            updatedRestaurant.setLatitude(restaurant.getLatitude());
            updatedRestaurant.setLongitude(restaurant.getLongitude());
            updatedRestaurant.setHourOpened(restaurant.getHourOpened());
            updatedRestaurant.setHourClosed(restaurant.getHourClosed());
            updatedRestaurant.setZone(restaurant.getZone());
            updatedRestaurant.setSerie(restaurant.getSerie());
            updatedRestaurant.setPhotos(restaurant.getPhotos());
            updatedRestaurant.setSpecialite(restaurant.getSpecialite());

            Restaurant savedRestaurant = restaurantService.save(updatedRestaurant);
            return new ResponseEntity<>(savedRestaurant, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Supprimer un restaurant existant
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteRestaurant(@PathVariable("id") int id) {
        try {
            restaurantService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/
}




