package com.restau.localisationRes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restau.localisationRes.entities.Specialite;

public interface SpecialiteRepository extends JpaRepository<Specialite, Integer> {

	List<Specialite> findAll();
	Specialite findById(int id);


}
