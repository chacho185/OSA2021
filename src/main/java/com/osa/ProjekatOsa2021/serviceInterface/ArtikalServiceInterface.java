package com.osa.ProjekatOsa2021.serviceInterface;

import java.util.List;

import com.osa.ProjekatOsa2021.model.Artikal;

public interface ArtikalServiceInterface {

	public List<Artikal> getAll();
	
	public Artikal getById(Long id);
	
	public Artikal save(Artikal artikal);
	
	public void delete(Long id);
}
