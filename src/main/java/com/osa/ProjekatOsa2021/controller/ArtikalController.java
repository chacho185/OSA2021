package com.osa.ProjekatOsa2021.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osa.ProjekatOsa2021.dto.ArtikalDTO;
import com.osa.ProjekatOsa2021.model.Artikal;
import com.osa.ProjekatOsa2021.model.Prodavac;
import com.osa.ProjekatOsa2021.serviceInterface.ArtikalServiceInterface;
import com.osa.ProjekatOsa2021.serviceInterface.ProdavacServiceInterface;

@RestController
@RequestMapping(value = "api/artikal")
public class ArtikalController {

	@Autowired
	ArtikalServiceInterface artikalServiceInterface;
	
	@Autowired
	ProdavacServiceInterface prodavacServiceInterface;
	
	@GetMapping
	public ResponseEntity<List<ArtikalDTO>> getAllArtikal(){
		List<Artikal> artikli = artikalServiceInterface.getAll();
		
		List<ArtikalDTO> artikliDTOs = new ArrayList<ArtikalDTO>();
		
		for (Artikal artikal : artikli) {
			artikliDTOs.add(new ArtikalDTO(artikal));
		}
		return new ResponseEntity<List<ArtikalDTO>>(artikliDTOs, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ArtikalDTO> saveAccount(@RequestBody ArtikalDTO artikalDTO){
		
		Prodavac prodavac = prodavacServiceInterface.getById(artikalDTO.getProdavacDTO().getId());
		
		Artikal artikal = new Artikal();
		artikal.setNaziv(artikalDTO.getNaziv());
		artikal.setOpis(artikalDTO.getOpis());
		artikal.setCena(artikalDTO.getCena());
		artikal.setPutanjaSlike(artikalDTO.getPutanjaSlike());
		artikal.setProdavac(prodavac);
		artikal = artikalServiceInterface.save(artikal);
		
		return new ResponseEntity<ArtikalDTO>(new ArtikalDTO(artikal), HttpStatus.CREATED);
	}
}
