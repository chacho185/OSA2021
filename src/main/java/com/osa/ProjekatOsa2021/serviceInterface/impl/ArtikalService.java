package com.osa.ProjekatOsa2021.serviceInterface.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osa.ProjekatOsa2021.model.Artikal;
import com.osa.ProjekatOsa2021.repository.ArtikalRepository;
import com.osa.ProjekatOsa2021.serviceInterface.ArtikalServiceInterface;

@Service
public class ArtikalService implements ArtikalServiceInterface {

	@Autowired
	ArtikalRepository artikalRepository;
	
	@Override
	public List<Artikal> getAll() {
		return artikalRepository.findAll();
	}

	@Override
	public Artikal getById(Long id) {
		return artikalRepository.findOneById(id);
	}

	@Override
	public Artikal save(Artikal artikal) {
		return artikalRepository.save(artikal);
	}

	@Override
	public void delete(Long id) {
		artikalRepository.deleteById(id);
	}

}
