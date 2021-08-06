package com.osa.ProjekatOsa2021.serviceInterface.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osa.ProjekatOsa2021.model.Kupac;
import com.osa.ProjekatOsa2021.repository.KupacRepository;
import com.osa.ProjekatOsa2021.serviceInterface.KupacServiceInterface;
@Service
public class KupacService implements KupacServiceInterface {
	
	@Autowired
	KupacRepository kupacRepository;
	
	@Override
	public List<Kupac> getAll() {
		
		return kupacRepository.findAll();
	}

	@Override
	public Kupac getById(Integer id) {
		
		return kupacRepository.findOneById(id);
	}

	@Override
	public Kupac save(Kupac k) {
		// TODO Auto-generated method stub
		return kupacRepository.save(k);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		kupacRepository.deleteById(id);
		

	}

}
