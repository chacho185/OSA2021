package com.osa.ProjekatOsa2021.serviceInterface;

import java.util.List;

import com.osa.ProjekatOsa2021.model.Akcija;


public interface AkcijaServiceInterface {
	
	public List<Akcija> getAll();
	
	public Akcija getById(Long id);
	
	public Akcija save(Akcija akcija);
	
	public void delete(Long id);

}
