package com.osa.ProjekatOsa2021.serviceInterface.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osa.ProjekatOsa2021.model.Prodavac;
import com.osa.ProjekatOsa2021.repository.ProdavacRepository;
import com.osa.ProjekatOsa2021.serviceInterface.ProdavacServiceInterface;
@Service
public class ProdavacService implements ProdavacServiceInterface {

	@Autowired
	ProdavacRepository prodavacRepository;
	
	@Override
	public List<Prodavac> getAll() {
		
		return prodavacRepository.findAll();
	}

	@Override
	public Prodavac getById(Integer id) {
		
		return prodavacRepository.findOneById(id);
	}

	@Override
	public Prodavac save(Prodavac p) {
		
		return prodavacRepository.save(p);
	}

	@Override
	public void delete(Long id) {
		
		prodavacRepository.deleteById(id);

	}

}
