package com.osa.ProjekatOsa2021.serviceInterface.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.osa.ProjekatOsa2021.dto.ArtikalDTO;
import com.osa.ProjekatOsa2021.model.Artikal;
import com.osa.ProjekatOsa2021.model.Prodavac;
import com.osa.ProjekatOsa2021.repository.ArtikalRepository;
import com.osa.ProjekatOsa2021.repository.ProdavacRepository;
import com.osa.ProjekatOsa2021.serviceInterface.ArtikalServiceInterface;

@Service
public class ArtikalService implements ArtikalServiceInterface {

	@Autowired
	ArtikalRepository artikalRepository;
	
	@Autowired
	ProdavacRepository prodavacRepository;
	
	@Override
	public List<ArtikalDTO> getAll() {
		List<Artikal> artikli = artikalRepository.findAll();
		
		List<ArtikalDTO> artikliDTOs = new ArrayList<ArtikalDTO>();
		
		for (Artikal artikal : artikli) {
			artikliDTOs.add(new ArtikalDTO(artikal));
		}
		return artikliDTOs;
	}

	@Override
	public ArtikalDTO getById(Long artikalId) throws Exception {
		Artikal artikal = artikalRepository.findOneById(artikalId);
		
		if(artikal == null) {
			throw new Exception("Ne postoji Artikal!");
		}
		return new ArtikalDTO(artikal);
	}

	@Override
	public ArtikalDTO save(ArtikalDTO artikalDTO) {
		
		Long id = artikalDTO.getProdavacDTO();
		Prodavac p = prodavacRepository.findOneById(id);
		
		Artikal artikal = new Artikal();
		artikal.setNaziv(artikalDTO.getNaziv());
		artikal.setOpis(artikalDTO.getOpis());
		artikal.setCena(artikalDTO.getCena());
		artikal.setPutanjaSlike(artikalDTO.getPutanjaSlike());
		artikal.setProdavac(p);
		
		artikal = artikalRepository.save(artikal);
		return new ArtikalDTO(artikal);
	}

	@Override
	public void delete(Long id) {
		artikalRepository.deleteById(id);
	}
	
	@Override
    public ArtikalDTO update(Long id, ArtikalDTO artikalDTO) {
        Artikal artikal = artikalRepository.findOneById(id);
        System.out.println("artikal" + artikal.getNaziv());
        Prodavac prodavac = artikal.getProdavac();
        artikal.setNaziv(artikalDTO.getNaziv());
        artikal.setOpis(artikalDTO.getOpis());
		artikal.setCena(artikalDTO.getCena());
		artikal.setPutanjaSlike(artikalDTO.getPutanjaSlike());
		artikal.setProdavac(prodavac);
       
		artikal = artikalRepository.save(artikal);
		return new ArtikalDTO(artikal);
    }

	@Override
	public List<ArtikalDTO> findByProdavac(Long id) {
		
		List<Artikal> artikli = artikalRepository.findByProdavac_id(id);
		
		List<ArtikalDTO> artikliDTOs = new ArrayList<ArtikalDTO>();
		
		for (Artikal artikal : artikli) {
			artikliDTOs.add(new ArtikalDTO(artikal));
		}
		return artikliDTOs;
	}

}
