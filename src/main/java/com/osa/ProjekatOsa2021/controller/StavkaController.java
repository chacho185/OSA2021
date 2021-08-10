package com.osa.ProjekatOsa2021.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osa.ProjekatOsa2021.dto.AkcijaDTO;
import com.osa.ProjekatOsa2021.dto.ArtikalDTO;
import com.osa.ProjekatOsa2021.dto.ProdavacDTO;
import com.osa.ProjekatOsa2021.dto.StavkaDTO;
import com.osa.ProjekatOsa2021.model.Akcija;
import com.osa.ProjekatOsa2021.model.Artikal;
import com.osa.ProjekatOsa2021.model.Porudzbina;
import com.osa.ProjekatOsa2021.model.Prodavac;
import com.osa.ProjekatOsa2021.model.Stavka;
import com.osa.ProjekatOsa2021.serviceInterface.ArtikalServiceInterface;
import com.osa.ProjekatOsa2021.serviceInterface.PorudzbinaServiceInterface;
import com.osa.ProjekatOsa2021.serviceInterface.StavkaServiceInterface;

@RestController
@RequestMapping(value = "api/stavka")
public class StavkaController {
	
	@Autowired
	StavkaServiceInterface stavkaServiceInterface;
	
	@Autowired
	PorudzbinaServiceInterface porudzbinaServiceInterface;
	
	@Autowired
	ArtikalServiceInterface artikalServiceInterface;
	
	
	@GetMapping
	public ResponseEntity<List<StavkaDTO>> getAllStavka(){
		
		return ResponseEntity.ok().body(stavkaServiceInterface.getAll());
	}
	
	@PostMapping
	public ResponseEntity<StavkaDTO> saveAccount(@RequestBody StavkaDTO stavkaDTO) throws Exception{
		
		return ResponseEntity.ok().body(stavkaServiceInterface.save(stavkaDTO));
	}
	
	@GetMapping(value = "/{id}")
	
	public ResponseEntity<StavkaDTO> getOneStavka(@PathVariable("id") Long id ) throws Exception {
		
		return ResponseEntity.ok().body(stavkaServiceInterface.getById(id));
	}

}
