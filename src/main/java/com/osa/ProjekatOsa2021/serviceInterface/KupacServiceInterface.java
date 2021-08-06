package com.osa.ProjekatOsa2021.serviceInterface;

import java.util.List;

import com.osa.ProjekatOsa2021.model.Kupac;

public interface KupacServiceInterface {
	
	    public List<Kupac> getAll();
		
		public Kupac getById(Integer id);
		
		public Kupac save(Kupac k);
		
		public void delete(Long id);


}
