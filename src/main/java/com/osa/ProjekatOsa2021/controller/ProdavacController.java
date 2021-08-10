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
		
		return ResponseEntity.ok().body(prodavacServiceInterface.getAll());
		
	}
	
	@PostMapping
	public ResponseEntity<ProdavacDTO> saveAccount(@RequestBody ProdavacDTO prodavacDTO){
		
		
		return  ResponseEntity.ok().body(prodavacServiceInterface.save(prodavacDTO));
				
	}
	
	@GetMapping(value = "/{id}")
	
	public ResponseEntity<ProdavacDTO> getOneProdavac(@PathVariable("id") Long id ) throws Exception {
		
		return ResponseEntity.ok().body(prodavacServiceInterface.getById(id));
	}

	

}
