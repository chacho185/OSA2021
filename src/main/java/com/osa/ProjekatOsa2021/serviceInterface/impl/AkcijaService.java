package com.osa.ProjekatOsa2021.serviceInterface.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.osa.ProjekatOsa2021.dto.AkcijaDTO;
import com.osa.ProjekatOsa2021.dto.StavkaDTO;
import com.osa.ProjekatOsa2021.model.Akcija;
import com.osa.ProjekatOsa2021.model.Prodavac;
import com.osa.ProjekatOsa2021.model.Stavka;
import com.osa.ProjekatOsa2021.repository.AkcijaRepository;
import com.osa.ProjekatOsa2021.repository.ProdavacRepository;
import com.osa.ProjekatOsa2021.serviceInterface.AkcijaServiceInterface;


@Service
public class AkcijaService implements AkcijaServiceInterface {
	
	@Autowired
	AkcijaRepository akcijaRepository;
	
	@Autowired
	ProdavacRepository prodavacRepository;

	@Override
	public List<AkcijaDTO> getAll() {
		// TODO Auto-generated method stub
		List<Akcija> akcija = akcijaRepository.findAll();
		
		List<AkcijaDTO> akcijaDTOs = new ArrayList<AkcijaDTO>();
		
		for (Akcija akcijaa : akcija) {
			akcijaDTOs.add(new AkcijaDTO(akcijaa));
		}
		return akcijaDTOs;
	}

	@Override
	public AkcijaDTO getById(Long id) throws Exception {
		// TODO Auto-generated method stub
		Akcija akcija = akcijaRepository.findOneById(id);
		
		if(akcija == null) {
			throw new Exception("Ne postoji akcija!");
		}
		return new AkcijaDTO(akcija);
	}

	@Override
	public AkcijaDTO save(AkcijaDTO akcijaDTO) {
		// TODO Auto-generated method stub
		
		Long id = akcijaDTO.getProdavacDTO();
		Prodavac p = prodavacRepository.findOneById(id);

		Akcija akcija = new Akcija();
		akcija.setProcenat(akcijaDTO.getProcenat());
		akcija.setOdKad(akcijaDTO.getOdKad());
		akcija.setDoKad(akcijaDTO.getDoKad());
		akcija.setTekst(akcijaDTO.getTekst());
		akcija.setProdavac(p);
		
		akcija = akcijaRepository.save(akcija);
		return new AkcijaDTO(akcija);
	}

	@Override
	public void delete(Long id) {
		akcijaRepository.deleteById(id);
		
	}

	
}
