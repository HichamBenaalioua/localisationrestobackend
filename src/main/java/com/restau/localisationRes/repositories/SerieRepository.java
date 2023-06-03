package com.restau.localisationRes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restau.localisationRes.entities.Serie;

public interface SerieRepository extends JpaRepository<Serie, Integer> {

	List<Serie> findAll();
	Serie findById(int id);
	Serie findByNom(String nomSerie);
}
