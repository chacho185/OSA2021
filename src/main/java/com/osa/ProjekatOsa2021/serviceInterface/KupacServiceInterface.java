package com.osa.ProjekatOsa2021.serviceInterface;

import java.util.List;

import com.osa.ProjekatOsa2021.dto.KupacDTO;
import com.osa.ProjekatOsa2021.model.Kupac;

public interface KupacServiceInterface {
	
	    public List<KupacDTO> getAll();
		
		public KupacDTO getById(Long id) throws Exception;
		
		public KupacDTO save(KupacDTO k);
		
		public void delete(Long id);


}
