package com.osa.ProjekatOsa2021.serviceInterface;

import java.util.List;

import com.osa.ProjekatOsa2021.model.Prodavac;

public interface ProdavacServiceInterface {
	
	List<Prodavac> getAll();
	
	Prodavac getById(Integer id);
	
	Prodavac save(Prodavac p);
	
	void delete(Long id);

}
