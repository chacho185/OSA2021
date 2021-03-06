package com.osa.ProjekatOsa2021.serviceInterface;

import java.util.List;

import com.osa.ProjekatOsa2021.dto.ArtikalDTO;
import com.osa.ProjekatOsa2021.dto.StavkaDTO;
import com.osa.ProjekatOsa2021.dto.StavkeDTO;
import com.osa.ProjekatOsa2021.model.Stavka;



public interface StavkaServiceInterface {
	
	public List<StavkaDTO> getAll();
	
	public StavkaDTO getById(Long id) throws Exception;
	
	public StavkaDTO save(StavkaDTO stavka);
	
	public StavkaDTO update(Long id ,StavkaDTO stavka);
	
	public List<StavkaDTO> findByArtikalAndPorudzbina(Long artikalId,Long porudzbinaId);
	
	public List<StavkeDTO> findByPorudzbina(Long porudzbinaId);
	
	public void delete(Long id);

}
