package com.restau.localisationRes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restau.localisationRes.dao.IDao;
import com.restau.localisationRes.entities.Ville;
import com.restau.localisationRes.repositories.VilleRepository;



@Service
public class VilleService implements IDao<Ville> {
	
	@Autowired(required=true)
	private VilleRepository villeRepository;

	@Override
	public void save(Ville o) {
		villeRepository.save(o);
		
	}

	@Override
	public List<Ville> findAll() {
		return villeRepository.findAll();
		//return null;
	}

	@Override
	public void delete(Ville o) {
		villeRepository.delete(o);
		
	}

	@Override
	public void update(Ville o) {
		villeRepository.save(o);
		
	}

	@Override
	public Ville findById(int id) {
		return villeRepository.findById(id);
	}

	public Ville findByNom(String nomVille) {
		return villeRepository.findByNom(nomVille);
	}

	
}