package com.osa.ProjekatOsa2021.controller;

import java.security.Principal;
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
import com.osa.ProjekatOsa2021.dto.PorudzbinaDTO;
import com.osa.ProjekatOsa2021.model.Artikal;
import com.osa.ProjekatOsa2021.model.Kupac;
import com.osa.ProjekatOsa2021.model.Porudzbina;
import com.osa.ProjekatOsa2021.model.Prodavac;
import com.osa.ProjekatOsa2021.serviceInterface.KupacServiceInterface;
import com.osa.ProjekatOsa2021.serviceInterface.PorudzbinaServiceInterface;

@RestController
@RequestMapping(value = "api/porudzbina")
public class PorudzbinaController {
	
	@Autowired
	PorudzbinaServiceInterface porudzbinaServiceInterface;
	
	@Autowired
	KupacServiceInterface kupacServiceInterface;
	
	@GetMapping
	public ResponseEntity<List<PorudzbinaDTO>> getAllPorudzbina(){
		
		return  ResponseEntity.ok().body(porudzbinaServiceInterface.getAll());
	}
	
	@PostMapping
	public ResponseEntity<PorudzbinaDTO> saveAccount(@RequestBody PorudzbinaDTO porudzbinaDTO, Principal principal){
	
//		System.out.println(principal.getName() + " aaaaaaaaaaa---------------------");
		return  ResponseEntity.ok().body(porudzbinaServiceInterface.save(porudzbinaDTO, "danda"));
	}
	
	@GetMapping(value = "/{id}")
	
	public ResponseEntity<PorudzbinaDTO> getOnePorudzbina(@PathVariable("id") Long id) throws Exception {
		
		return ResponseEntity.ok().body(porudzbinaServiceInterface.getById(id));
	}
	
	@DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteArtikal(@PathVariable("id") Long id){
       porudzbinaServiceInterface.delete(id);
        return  ResponseEntity.noContent().build();
    }
	
	@PutMapping(value = "/{id}")
    public ResponseEntity<PorudzbinaDTO> updatePorudzbina(@RequestBody PorudzbinaDTO porudzbinaDTO, @PathVariable("id") Long id){
        try {
            porudzbinaServiceInterface.update(id,porudzbinaDTO);
            return  ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
