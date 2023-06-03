package com.restau.localisationRes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restau.localisationRes.dao.IDao;
import com.restau.localisationRes.entities.Photo;
import com.restau.localisationRes.repositories.PhotoRepository;

@Service
public class PhotoService implements IDao<Photo> {

	@Autowired
	private PhotoRepository photoRepository;
	@Override
	public void save(Photo o) {
		photoRepository.save(o);
		
	}

	@Override
	public List<Photo> findAll() {
		// TODO Auto-generated method stub
		return photoRepository.findAll();
	}

	@Override
	public void delete(Photo o) {
		// TODO Auto-generated method stub
		photoRepository.delete(o);
		
	}

	@Override
	public void update(Photo o) {
		// TODO Auto-generated method stub
		photoRepository.save(o);

		
	}

	@Override
	public Photo findById(int id) {
		// TODO Auto-generated method stub
		return photoRepository.findById(id);
	}
	
	

}