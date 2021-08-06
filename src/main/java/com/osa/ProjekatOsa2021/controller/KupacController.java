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
		
	List<Kupac> kupci = kupacServiceInterface.getAll();
	
	List<KupacDTO> kupciDTOs = new ArrayList<KupacDTO>();
	
	for (Kupac kupac : kupci) {
		kupciDTOs.add(new KupacDTO(kupac));
		
	}
	
	return new ResponseEntity<List<KupacDTO>>(kupciDTOs , HttpStatus.OK);
	
	
		
	}
	
	@PostMapping
	public ResponseEntity<KupacDTO> saveAccount(@RequestBody KupacDTO kupacDTO){
		
		Kupac kupac = new Kupac();
		kupac.setAdresa(kupacDTO.getAdresa());
		kupac.setIme(kupacDTO.getIme());
		kupac.setPrezime(kupacDTO.getPrezime());
		kupac.setUsername(kupacDTO.getKorisnickoIme());
		kupac.setPassword(kupacDTO.getLozinka());
		kupac.setBlokiran(kupac.getBlokiran());
		kupac = kupacServiceInterface.save(kupac);
		
		return new ResponseEntity<KupacDTO>(new KupacDTO(kupac), HttpStatus.CREATED);
	}

	
	
	

}
