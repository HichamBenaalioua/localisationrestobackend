package com.restau.localisationRes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restau.localisationRes.dao.IDao;
import com.restau.localisationRes.entities.Specialite;
import com.restau.localisationRes.repositories.SpecialiteRepository;
import com.restau.localisationRes.repositories.VilleRepository;


@Service
public class SpecialiteService implements IDao<Specialite>{
	
	@Autowired(required=true)
	private SpecialiteRepository specialiteRepository;

	@Override
	public void save(Specialite o) {
		specialiteRepository.save(o);
		
	}

	@Override
	public List<Specialite> findAll() {
		return specialiteRepository.findAll();
		//return null;
	}

	@Override
	public void delete(Specialite o) {
		specialiteRepository.delete(o);
		
	}

	@Override
	public void update(Specialite o) {
		specialiteRepository.save(o);
		
	}

	@Override
	public Specialite findById(int id) {
		return specialiteRepository.findById(id);
	}

	

	

}