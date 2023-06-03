package com.restau.localisationRes.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restau.localisationRes.dao.IDao;
import com.restau.localisationRes.entities.Ville;
import com.restau.localisationRes.entities.Zone;
import com.restau.localisationRes.repositories.ZoneRepository;


@Service
public class ZoneService implements IDao<Zone> {
	
	@Autowired(required=true)
	private ZoneRepository zoneRepository;

	@Override
	public void save(Zone o) {
		zoneRepository.save(o);
		
	}

	@Override
	public List<Zone> findAll() {
		return zoneRepository.findAll();
		//return null;
	}

	@Override
	public void delete(Zone o) {
		zoneRepository.delete(o);
		
	}

	@Override
	public void update(Zone o) {
		zoneRepository.save(o);
		
	}

	@Override
	public Zone findById(int id) {
		return zoneRepository.findById(id);
	}
	
	public Zone findByNomAndVille(String nomZone, Ville ville) {
		return zoneRepository.findByNomAndVille(nomZone, ville);
	}

	
}