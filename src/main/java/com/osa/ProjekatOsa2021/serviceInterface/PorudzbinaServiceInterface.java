package com.osa.ProjekatOsa2021.serviceInterface;

import java.util.List;

import com.osa.ProjekatOsa2021.dto.ArtikalDTO;
import com.osa.ProjekatOsa2021.dto.PorudzbinaDTO;
import com.osa.ProjekatOsa2021.model.Porudzbina;

public interface PorudzbinaServiceInterface {
	
	public List<PorudzbinaDTO> getAll();
	
	public PorudzbinaDTO getById(Long id) throws Exception;
	
	public PorudzbinaDTO save(PorudzbinaDTO porudzbina);
	
	public PorudzbinaDTO update(Long id ,PorudzbinaDTO artikal);
	
	public void delete(Long id);

}
