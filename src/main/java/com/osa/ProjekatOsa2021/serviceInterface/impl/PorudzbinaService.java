package com.osa.ProjekatOsa2021.serviceInterface.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.osa.ProjekatOsa2021.dto.ArtikalDTO;
import com.osa.ProjekatOsa2021.dto.PorudzbinaDTO;
import com.osa.ProjekatOsa2021.dto.ProdavacDTO;
import com.osa.ProjekatOsa2021.model.Kupac;
import com.osa.ProjekatOsa2021.model.Porudzbina;
import com.osa.ProjekatOsa2021.model.Prodavac;
import com.osa.ProjekatOsa2021.repository.KupacRepository;
import com.osa.ProjekatOsa2021.repository.PorudzbinaRepository;
import com.osa.ProjekatOsa2021.serviceInterface.PorudzbinaServiceInterface;

@Service
public class PorudzbinaService implements PorudzbinaServiceInterface {

	@Autowired
	PorudzbinaRepository porudzbinaRepository;
	@Autowired
	KupacRepository kupacRepository;
	
	@Override
	public List<PorudzbinaDTO> getAll() {
		// TODO Auto-generated method stub
		List<Porudzbina> porudzbine = porudzbinaRepository.findAll();
		
		List<PorudzbinaDTO> porudzbineDTOs = new ArrayList<PorudzbinaDTO>();
		
		for (Porudzbina porudzbina : porudzbine) {
			porudzbineDTOs.add(new PorudzbinaDTO(porudzbina));
		}
		return porudzbineDTOs;
		
	}

	@Override
	public PorudzbinaDTO getById(Long id) throws Exception {
		// TODO Auto-generated method stub
		Porudzbina porudzbina = porudzbinaRepository.findOneById(id);
		
		if(porudzbina == null) {
			throw new Exception("Ne postoji porudzbina!");
		}
		return new PorudzbinaDTO(porudzbina);
	}

	@Override
	public PorudzbinaDTO save(PorudzbinaDTO porudzbinaDTO, String name) {
		// TODO Auto-generated method stub
		Long id = porudzbinaDTO.getKupacDTO();
		Kupac k = kupacRepository.findOneByUsername(name);
		Porudzbina porudzbina = new Porudzbina();
		porudzbina.setSatnica(porudzbinaDTO.getSatnica());
		porudzbina.setDostavljeno(porudzbinaDTO.getDostavljeno());
		porudzbina.setOcena(porudzbinaDTO.getOcena());
		porudzbina.setKomentar(porudzbinaDTO.getKomentar());
		porudzbina.setAnonimiKomentar(porudzbinaDTO.getAnonimiKomentar());
		porudzbina.setArhiviraniKomentar(porudzbinaDTO.getArhiviraniKomentar());
		
		porudzbina.setKupac(k);
		porudzbina = porudzbinaRepository.save(porudzbina);
		
		return new PorudzbinaDTO(porudzbina);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
		porudzbinaRepository.deleteById(id);

	}
	
	@Override
    public PorudzbinaDTO update(Long id, PorudzbinaDTO porudzbinaDTO) {
		Porudzbina porudzbina = porudzbinaRepository.findOneById(id);
		Kupac kupac = porudzbina.getKupac();
		
		porudzbina.setSatnica(porudzbinaDTO.getSatnica());
		porudzbina.setDostavljeno(porudzbinaDTO.getDostavljeno());
		porudzbina.setOcena(porudzbinaDTO.getOcena());
		porudzbina.setKomentar(porudzbinaDTO.getKomentar());
		porudzbina.setAnonimiKomentar(porudzbinaDTO.getAnonimiKomentar());
		porudzbina.setArhiviraniKomentar(porudzbinaDTO.getArhiviraniKomentar());
		porudzbina.setKupac(kupac);
		
		
		porudzbina = porudzbinaRepository.save(porudzbina);
		return new PorudzbinaDTO(porudzbina);
		
	}

}
