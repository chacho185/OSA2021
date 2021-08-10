package com.osa.ProjekatOsa2021.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osa.ProjekatOsa2021.dto.AkcijaDTO;
import com.osa.ProjekatOsa2021.dto.ArtikalDTO;
import com.osa.ProjekatOsa2021.dto.StavkaDTO;
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
		
		return ResponseEntity.ok().body(akcijaServiceInterface.getAll());
		
	}
	
	@PostMapping
	public ResponseEntity<AkcijaDTO> saveAccount(@RequestBody AkcijaDTO akcijaDTO){
		
			
		return  ResponseEntity.ok().body(akcijaServiceInterface.save(akcijaDTO));
	}
	
	@GetMapping(value = "/{id}")
	
	public ResponseEntity<AkcijaDTO> getOneAkcija(@PathVariable("id") Long id ) throws Exception {
		
		return ResponseEntity.ok().body(akcijaServiceInterface.getById(id));
	
	}
	
	@DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteAkcija(@PathVariable("id") Long id){
       akcijaServiceInterface.delete(id);
        return  ResponseEntity.noContent().build();
    }
	
	@PutMapping(value = "/{id}")
    public ResponseEntity<AkcijaDTO> updateAkcija(@RequestBody AkcijaDTO akcijaDTO, @PathVariable("id") Long id){
        try {
            akcijaServiceInterface.update(id,akcijaDTO);
            return  ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
	
	
}
