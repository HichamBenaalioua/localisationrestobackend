package com.restau.localisationRes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restau.localisationRes.entities.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

	List<Restaurant> findAll();
	Restaurant findById(int id);
	List<Restaurant> findByZoneVilleNomAndZoneNom(String ville, String zone);
	List<Restaurant> findByZoneId(String zoneId);
}
