package com.restau.localisationRes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restau.localisationRes.entities.Photo;
import com.restau.localisationRes.services.PhotoService;

@CrossOrigin
@RestController
@RequestMapping("/photos")
public class PhotoController {

	@Autowired
	private PhotoService photoService;

	@PostMapping("/save")
	public void save(@RequestBody Photo photo) {
		photoService.save(photo);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(required = true) String id) {
		Photo s = photoService.findById(Integer.parseInt(id));
		photoService.delete(s);
	}

	@GetMapping("/all")
	public List<Photo> findAll() {
		return photoService.findAll();
	}


	@GetMapping("/{id}")
	public Photo findById(@PathVariable int id) {
		return photoService.findById(id);
	}
	
	/*
	

    @Autowired
    private PhotoService photoService;

    // Obtenir toutes les photos
    @GetMapping
    public List<Photo> getAllPhotos() {
        return photoService.findAll();
    }

    // Obtenir une photo par ID
    @GetMapping("/{id}")
    public ResponseEntity<Photo> getPhotoById(@PathVariable(value = "id") int photoId) {
        Optional<Photo> photo = photoService.findById(photoId);
        if (photo.isPresent()) {
            return ResponseEntity.ok().body(photo.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Créer une nouvelle photo
    @PostMapping
    public Photo createPhoto(@RequestBody Photo photo) {
        return photoService.save(photo);
    }

    // Mettre à jour une photo existante
    @PutMapping("/{id}")
    public ResponseEntity<Photo> updatePhoto(@PathVariable(value = "id") int photoId, @RequestBody Photo photoDetails) {
        Optional<Photo> photo = photoService.findById(photoId);
        if (photo.isPresent()) {
            Photo updatedPhoto = photo.get();
            updatedPhoto.setUrl(photoDetails.getUrl());
            updatedPhoto.setRestaurant(photoDetails.getRestaurant());
            Photo savedPhoto = photoService.save(updatedPhoto);
            return ResponseEntity.ok(savedPhoto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Supprimer une photo existante
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePhoto(@PathVariable(value = "id") int photoId) {
        Optional<Photo> photo = photoService.findById(photoId);
        if (photo.isPresent()) {
            photoService.delete(photo.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/
}
