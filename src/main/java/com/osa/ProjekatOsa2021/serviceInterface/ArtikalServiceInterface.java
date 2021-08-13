package com.osa.ProjekatOsa2021.serviceInterface;

import java.util.List;

import com.osa.ProjekatOsa2021.dto.ArtikalDTO;
import com.osa.ProjekatOsa2021.model.Artikal;

public interface ArtikalServiceInterface {

	public List<ArtikalDTO> getAll();
	
	public ArtikalDTO getById(Long id) throws Exception;
	
	public ArtikalDTO save(ArtikalDTO artikal);
	
	public ArtikalDTO update(Long id ,ArtikalDTO artikal);
	
	public List<ArtikalDTO> findByProdavac(Long id);
	
	public void delete(Long id);
}
