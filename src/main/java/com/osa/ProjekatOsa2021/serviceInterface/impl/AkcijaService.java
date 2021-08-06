package com.osa.ProjekatOsa2021.serviceInterface.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osa.ProjekatOsa2021.model.Akcija;
import com.osa.ProjekatOsa2021.repository.AkcijaRepository;
import com.osa.ProjekatOsa2021.serviceInterface.AkcijaServiceInterface;


@Service
public class AkcijaService implements AkcijaServiceInterface {
	
	@Autowired
	AkcijaRepository akcijaRepository;

	@Override
	public List<Akcija> getAll() {
		// TODO Auto-generated method stub
		return akcijaRepository.findAll();
	}

	@Override
	public Akcija getById(Long id) {
		// TODO Auto-generated method stub
		return akcijaRepository.findOneById(id);
	}

	@Override
	public Akcija save(Akcija akcija) {
		// TODO Auto-generated method stub
		return akcijaRepository.save(akcija);
	}

	@Override
	public void delete(Long id) {
		akcijaRepository.deleteById(id);
		
	}

	
}
