package com.osa.ProjekatOsa2021.serviceInterface;

import java.util.List;

import com.osa.ProjekatOsa2021.dto.AdminDTO;
import com.osa.ProjekatOsa2021.dto.AkcijaDTO;
import com.osa.ProjekatOsa2021.model.Admin;

public interface AdminServiceInterface {
	
	public List<AdminDTO> getAll();
	
	public AdminDTO getById(Long id) throws Exception;
	
	public AdminDTO save(AdminDTO a);
	
	public AdminDTO update(Long id ,AdminDTO admin);

	
	public void delete(Long id);
}
