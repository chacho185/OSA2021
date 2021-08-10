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

import com.osa.ProjekatOsa2021.dto.KupacDTO;
import com.osa.ProjekatOsa2021.dto.ProdavacDTO;
import com.osa.ProjekatOsa2021.model.Kupac;
import com.osa.ProjekatOsa2021.model.Prodavac;
import com.osa.ProjekatOsa2021.serviceInterface.KupacServiceInterface;

@RestController
@RequestMapping(value = "api/kupac")
public class KupacController {
	
	@Autowired
	KupacServiceInterface kupacServiceInterface;
	
	@GetMapping
	public ResponseEntity<List<KupacDTO>> getAllKupac() {
		
		return ResponseEntity.ok().body(kupacServiceInterface.getAll());
		
	}
	
	@PostMapping
	public ResponseEntity<KupacDTO> saveAccount(@RequestBody KupacDTO kupacDTO){
		
		return ResponseEntity.ok().body(kupacServiceInterface.save(kupacDTO));
	}
	
	@GetMapping(value = "/{id}") 
	
	public ResponseEntity<KupacDTO> getOneKupac(@PathVariable("id") Long id) throws Exception {
		
		return ResponseEntity.ok().body(kupacServiceInterface.getById(id));
	}

	
	
	

}
