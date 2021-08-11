package com.osa.ProjekatOsa2021.serviceInterface.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.osa.ProjekatOsa2021.dto.AdminDTO;
import com.osa.ProjekatOsa2021.dto.KupacDTO;
import com.osa.ProjekatOsa2021.model.Admin;
import com.osa.ProjekatOsa2021.model.Kupac;
import com.osa.ProjekatOsa2021.model.Prodavac;
import com.osa.ProjekatOsa2021.repository.KupacRepository;
import com.osa.ProjekatOsa2021.serviceInterface.KupacServiceInterface;
@Service
public class KupacService implements KupacServiceInterface {
	
	@Autowired
	KupacRepository kupacRepository;
	
	@Override
	public List<KupacDTO> getAll() {
		
		List<Kupac> kupci = kupacRepository.findAll();
		
		List<KupacDTO> kupciDTOs = new ArrayList<KupacDTO>();
		
		for (Kupac kupac : kupci) {
			kupciDTOs.add(new KupacDTO(kupac));
			
		}
		
		return kupciDTOs;
		
		
	}

	@Override
	public KupacDTO getById(Long id) throws Exception{
		
		Kupac kupac = kupacRepository.findOneById(id);
		
		if(kupac == null) {
			throw new Exception("Ne postoji kupac!");
		}
		
		return new KupacDTO(kupac);
	}

	@Override
	public KupacDTO save(KupacDTO kupacDTO) {
		// TODO Auto-generated method stub
		Kupac kupac = new Kupac();
		kupac.setAdresa(kupacDTO.getAdresa());
		kupac.setIme(kupacDTO.getIme());
		kupac.setPrezime(kupacDTO.getPrezime());
		kupac.setUsername(kupacDTO.getKorisnickoIme());
		kupac.setPassword(kupacDTO.getLozinka());
		kupac.setBlokiran(kupac.getBlokiran());
		kupac = kupacRepository.save(kupac);
		
		return new KupacDTO(kupac);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		kupacRepository.deleteById(id);
		

	}
	
	@Override
    public KupacDTO update(Long id, KupacDTO kupacDTO) {
		Kupac kupac = kupacRepository.findOneById(id);
		kupac.setAdresa(kupacDTO.getAdresa());
		kupac.setIme(kupacDTO.getIme());
		kupac.setPrezime(kupacDTO.getPrezime());
		kupac.setUsername(kupacDTO.getKorisnickoIme());
		kupac.setPassword(kupacDTO.getLozinka());
		kupac.setBlokiran(kupacDTO.getBlokiran());
		
		kupac = kupacRepository.save(kupac);
		return new KupacDTO(kupac);
		
	}
	
	

}
