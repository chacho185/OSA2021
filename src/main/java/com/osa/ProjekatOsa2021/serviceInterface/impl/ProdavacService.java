package com.osa.ProjekatOsa2021.serviceInterface.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.osa.ProjekatOsa2021.dto.ArtikalDTO;
import com.osa.ProjekatOsa2021.dto.KupacDTO;
import com.osa.ProjekatOsa2021.dto.ProdavacDTO;
import com.osa.ProjekatOsa2021.model.Artikal;
import com.osa.ProjekatOsa2021.model.Kupac;
import com.osa.ProjekatOsa2021.model.Prodavac;
import com.osa.ProjekatOsa2021.repository.ProdavacRepository;
import com.osa.ProjekatOsa2021.serviceInterface.ProdavacServiceInterface;
@Service
public class ProdavacService implements ProdavacServiceInterface {

	@Autowired
	ProdavacRepository prodavacRepository;
	
	@Override
	public List<ProdavacDTO> getAll() {
		
		List<Prodavac> prodavci = prodavacRepository.findAll();
		
		List<ProdavacDTO> prodavciDTOs = new ArrayList<ProdavacDTO>();
		
		for (Prodavac prodavac : prodavci) {
			prodavciDTOs.add(new ProdavacDTO(prodavac));
			
		}
		
		return prodavciDTOs;
		
		
	}

	@Override
	public ProdavacDTO getById(Long id) throws Exception {
		
		Prodavac prodavac = prodavacRepository.findOneById(id);
		
		if(prodavac == null) {
			throw new Exception("Ne postoji prodavac!");
		}
		return new ProdavacDTO(prodavac);
	}

	@Override
	public ProdavacDTO save(ProdavacDTO prodavacDTO) {
		
		Prodavac prodavac = new Prodavac();
		prodavac.setPoslujeOd(prodavacDTO.getPoslujeOd());
		prodavac.setEmail(prodavacDTO.getEmail());
		prodavac.setAdresa(prodavacDTO.getAdresa());
		prodavac.setNaziv(prodavacDTO.getNaziv());
		prodavac.setIme(prodavacDTO.getIme());
		prodavac.setPrezime(prodavacDTO.getPrezime());
		prodavac.setUsername(prodavacDTO.getKorisnickoIme());
		prodavac.setPassword(prodavacDTO.getLozinka());
		prodavac.setBlokiran(prodavac.getBlokiran());
		prodavac = prodavacRepository.save(prodavac);
		
		return new ProdavacDTO(prodavac);
		
	}

	@Override
	public void delete(Long id) {
		
		prodavacRepository.deleteById(id);

	}
	
	@Override
    public ProdavacDTO update(Long id, ProdavacDTO prodavacDTO) {
		Prodavac prodavac = prodavacRepository.findOneById(id);
		prodavac.setAdresa(prodavacDTO.getAdresa());
		prodavac.setIme(prodavacDTO.getIme());
		prodavac.setPrezime(prodavacDTO.getPrezime());
		prodavac.setUsername(prodavacDTO.getKorisnickoIme());
		prodavac.setPassword(prodavacDTO.getLozinka());
		prodavac.setBlokiran(prodavacDTO.getBlokiran());
		
		prodavac = prodavacRepository.save(prodavac);
		return new ProdavacDTO(prodavac);
		
	}

}
