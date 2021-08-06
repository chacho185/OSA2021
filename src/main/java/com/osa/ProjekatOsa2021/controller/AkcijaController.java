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

import com.osa.ProjekatOsa2021.dto.AkcijaDTO;
import com.osa.ProjekatOsa2021.dto.ArtikalDTO;
import com.osa.ProjekatOsa2021.model.Akcija;
import com.osa.ProjekatOsa2021.model.Artikal;
import com.osa.ProjekatOsa2021.model.Prodavac;
import com.osa.ProjekatOsa2021.serviceInterface.AkcijaServiceInterface;
import com.osa.ProjekatOsa2021.serviceInterface.ArtikalServiceInterface;
import com.osa.ProjekatOsa2021.serviceInterface.ProdavacServiceInterface;

@RestController
@RequestMapping(value = "api/akcija")
public class AkcijaController {
	
	@Autowired
	AkcijaServiceInterface akcijaServiceInterface;
	
	@Autowired
	ProdavacServiceInterface prodavacServiceInterface;
	
	
	@GetMapping
	public ResponseEntity<List<AkcijaDTO>> getAllAkcija(){
		List<Akcija> akcija = akcijaServiceInterface.getAll();
		
		List<AkcijaDTO> akcijaDTOs = new ArrayList<AkcijaDTO>();
		
		for (Akcija akcijaa : akcija) {
			akcijaDTOs.add(new AkcijaDTO(akcijaa));
		}
		return new ResponseEntity<List<AkcijaDTO>>(akcijaDTOs, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<AkcijaDTO> saveAccount(@RequestBody AkcijaDTO akcijaDTO){
		
		Prodavac prodavac = prodavacServiceInterface.getById(akcijaDTO.getProdavacDTO().getId());
		
		Akcija akcija = new Akcija();
		akcija.setProcenat(akcijaDTO.getProcenat());
		akcija.setOdKad(akcijaDTO.getOdKad());
		akcija.setDoKad(akcijaDTO.getDoKad());
		akcija.setTekst(akcijaDTO.getTekst());
		akcija.setProdavac(prodavac);
		akcija = akcijaServiceInterface.save(akcija);
		
		return new ResponseEntity<AkcijaDTO>(new AkcijaDTO(akcija), HttpStatus.CREATED);
	}
	

}
