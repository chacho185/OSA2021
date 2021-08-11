package com.osa.ProjekatOsa2021.serviceInterface.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.osa.ProjekatOsa2021.dto.AdminDTO;
import com.osa.ProjekatOsa2021.dto.AkcijaDTO;
import com.osa.ProjekatOsa2021.model.Admin;
import com.osa.ProjekatOsa2021.model.Akcija;
import com.osa.ProjekatOsa2021.model.Prodavac;
import com.osa.ProjekatOsa2021.repository.AdminRepository;
import com.osa.ProjekatOsa2021.serviceInterface.AdminServiceInterface;
@Service
public class AdminService implements AdminServiceInterface {

	@Autowired
	AdminRepository adminRepository;
	
	
	@Override
	public List<AdminDTO> getAll() {
		
		List<Admin> admini = adminRepository.findAll();
		
		List<AdminDTO> adminiDTOs = new ArrayList<AdminDTO>();
		
		for (Admin admin1 : admini) {
			adminiDTOs.add(new AdminDTO(admin1));
			
		}
		
		return adminiDTOs;
	}

	@Override
	public AdminDTO getById(Long id) throws Exception {
		// TODO Auto-generated method stub
		Admin admin = adminRepository.findOneById(id);
		
		if(admin == null) {
			throw new Exception("Ne postoji admin!");
		}
		
		return new AdminDTO(admin);
	}

	@Override
	public AdminDTO save(AdminDTO adminDTO) {
		// TODO Auto-generated method stub
		Admin admin = new Admin();
		admin.setIme(adminDTO.getIme());
		admin.setPrezime(adminDTO.getPrezime());
		admin.setUsername(adminDTO.getKorisnickoIme());
		admin.setPassword(adminDTO.getLozinka());
		admin.setBlokiran(admin.getBlokiran());
		admin = adminRepository.save(admin);
		
		return new AdminDTO(admin);
	}

	@Override
	public void delete(Long id) {
		
		 adminRepository.deleteById(id);
	}
	
	@Override
    public AdminDTO update(Long id, AdminDTO adminDTO) {
		Admin admin = adminRepository.findOneById(id);
		admin.setIme(adminDTO.getIme());
		admin.setPrezime(adminDTO.getPrezime());
		admin.setUsername(adminDTO.getKorisnickoIme());
		admin.setPassword(adminDTO.getLozinka());
		admin.setBlokiran(adminDTO.getBlokiran());
		
		admin = adminRepository.save(admin);
		return new AdminDTO(admin);
		
	}
}
