package com.osa.ProjekatOsa2021.serviceInterface;

import java.util.List;

import com.osa.ProjekatOsa2021.dto.AkcijaDTO;
import com.osa.ProjekatOsa2021.dto.ArtikalDTO;
import com.osa.ProjekatOsa2021.model.Akcija;


public interface AkcijaServiceInterface {
	
	public List<AkcijaDTO> getAll();
	
	public AkcijaDTO getById(Long id) throws Exception;
	
	public AkcijaDTO save(AkcijaDTO akcija);
	
	public AkcijaDTO update(Long id ,AkcijaDTO artikal);
	
	public void delete(Long id);

}
