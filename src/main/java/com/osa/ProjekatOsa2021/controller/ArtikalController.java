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
		
		return ResponseEntity.ok().body(artikalServiceInterface.getAll());
	}
	
	@PostMapping
	public ResponseEntity<ArtikalDTO> saveAccount(@RequestBody ArtikalDTO artikalDTO){
		
		return  ResponseEntity.ok().body(artikalServiceInterface.save(artikalDTO));

	}
	
	@GetMapping(value = "/{id}")
    public ResponseEntity<ArtikalDTO> getArtikal(@PathVariable("id") Long id) throws Exception{

        return ResponseEntity.ok().body(artikalServiceInterface.getById(id));
    }
	
	@DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteArtikal(@PathVariable("id") Long id){
       artikalServiceInterface.delete(id);
        return  ResponseEntity.noContent().build();
    }
	
	@PutMapping(value = "/{id}")
    public ResponseEntity<ArtikalDTO> updateArtikal(@RequestBody ArtikalDTO artikalDTO, @PathVariable("id") Long id){
        try {
            artikalServiceInterface.update(id,artikalDTO);
            return  ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
	
	@GetMapping(value = "/prodavac/{id}")
    public ResponseEntity<List<ArtikalDTO>> getArtikalByProdavac(@PathVariable("id") Long id) {

        return ResponseEntity.ok().body(artikalServiceInterface.findByProdavac(id));
    }
}
