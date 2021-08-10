package com.osa.ProjekatOsa2021.serviceInterface;

import java.util.List;

import com.osa.ProjekatOsa2021.dto.ProdavacDTO;
import com.osa.ProjekatOsa2021.model.Prodavac;

public interface ProdavacServiceInterface {
	
	List<ProdavacDTO> getAll();
	
	ProdavacDTO getById(Long id) throws Exception;
	
	ProdavacDTO save(ProdavacDTO p);
	
	void delete(Long id);

}
