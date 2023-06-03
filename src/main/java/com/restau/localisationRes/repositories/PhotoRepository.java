package com.restau.localisationRes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restau.localisationRes.entities.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Integer> {

	List<Photo> findAll();
	Photo findById(int id);

}
