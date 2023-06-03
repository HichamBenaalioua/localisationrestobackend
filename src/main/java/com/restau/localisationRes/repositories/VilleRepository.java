package com.restau.localisationRes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.restau.localisationRes.entities.Ville;


public interface VilleRepository extends JpaRepository<Ville, Integer> {

	List<Ville> findAll();
	Ville findById(int id);

	Ville findByNom(String nom);
	
	

}
