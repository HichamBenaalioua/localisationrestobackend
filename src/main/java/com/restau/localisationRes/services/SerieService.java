package com.restau.localisationRes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restau.localisationRes.dao.IDao;
import com.restau.localisationRes.entities.Serie;
import com.restau.localisationRes.repositories.SerieRepository;

@Service
public class SerieService implements IDao<Serie> {

	@Autowired(required = true)
	private SerieRepository serieRepository;

	@Override
	public void save(Serie o) {
		serieRepository.save(o);

	}

	@Override
	public void delete(Serie o) {
		serieRepository.delete(o);

	}

	@Override
	public void update(Serie o) {
		serieRepository.save(o);

	}

	@Override
	public List<Serie> findAll() {
		return serieRepository.findAll();
	}

	@Override
	public Serie findById(int id) {
		return serieRepository.findById(id);
	}

	public Serie findByNom(String nomSerie) {
		return serieRepository.findByNom(nomSerie);
	}
}
