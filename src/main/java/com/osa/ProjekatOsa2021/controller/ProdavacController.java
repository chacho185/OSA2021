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
import com.osa.ProjekatOsa2021.dto.ProdavacDTO;
import com.osa.ProjekatOsa2021.model.Artikal;
import com.osa.ProjekatOsa2021.model.Prodavac;
import com.osa.ProjekatOsa2021.serviceInterface.ProdavacServiceInterface;

@RestController
@RequestMapping(value = "api/prodavac")
public class ProdavacController {
	
	@Autowired
	ProdavacServiceInterface prodavacServiceInterface;
	
	@GetMapping
	public ResponseEntity<List<ProdavacDTO>> getAllProdavac() {
		
	List<Prodavac> prodavci = prodavacServiceInterface.getAll();
	
	List<ProdavacDTO> prodavciDTOs = new ArrayList<ProdavacDTO>();
	
	for (Prodavac prodavac : prodavci) {
		prodavciDTOs.add(new ProdavacDTO(prodavac));
		
	}
	
	return new ResponseEntity<List<ProdavacDTO>>(prodavciDTOs , HttpStatus.OK);
	
	
		
	}
	
	@PostMapping
	public ResponseEntity<ProdavacDTO> saveAccount(@RequestBody ProdavacDTO prodavacDTO){
		
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
		prodavac = prodavacServiceInterface.save(prodavac);
		
		return new ResponseEntity<ProdavacDTO>(new ProdavacDTO(prodavac), HttpStatus.CREATED);
	}

	

}
