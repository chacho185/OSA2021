package com.osa.ProjekatOsa2021.serviceInterface.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.osa.ProjekatOsa2021.dto.ProdavacDTO;
import com.osa.ProjekatOsa2021.dto.StavkaDTO;
import com.osa.ProjekatOsa2021.dto.StavkeDTO;
import com.osa.ProjekatOsa2021.model.Artikal;
import com.osa.ProjekatOsa2021.model.Porudzbina;
import com.osa.ProjekatOsa2021.model.Prodavac;
import com.osa.ProjekatOsa2021.model.Stavka;
import com.osa.ProjekatOsa2021.repository.ArtikalRepository;
import com.osa.ProjekatOsa2021.repository.PorudzbinaRepository;
import com.osa.ProjekatOsa2021.repository.StavkaRepository;
import com.osa.ProjekatOsa2021.serviceInterface.StavkaServiceInterface;

@Service
public class StavkaService implements StavkaServiceInterface {

	@Autowired
	StavkaRepository stavkaRepository;
	
	@Autowired
	ArtikalRepository artikalRepository;
	
	@Autowired
	PorudzbinaRepository porudzbinaRepository;
	
	
	@Override
	public List<StavkaDTO> getAll() {
		// TODO Auto-generated method stub
		List<Stavka> stavka = stavkaRepository.findAll();
		
		List<StavkaDTO> stavkaDTOs = new ArrayList<StavkaDTO>();
		
		for (Stavka stavkaa : stavka) {
			stavkaDTOs.add(new StavkaDTO(stavkaa));
		}
		return stavkaDTOs;
	}

	@Override
	public StavkaDTO getById(Long id) throws Exception {
		// TODO Auto-generated method stub
		Stavka stavka = stavkaRepository.findOneById(id);
		
		if(stavka == null) {
			throw new Exception("Ne postoji stavka!");
		}
		return new StavkaDTO(stavka);
	}

	
	@Override
    public StavkaDTO save(StavkaDTO stavkaDTO) {
        Long id = stavkaDTO.getArtikalDTO();
        Artikal a = artikalRepository.findOneById(id);
        Long idP = stavkaDTO.getPorudzbinaDTO();
        Porudzbina p = porudzbinaRepository.findOneById(idP);
        
        Stavka stavka = new Stavka();
		stavka.setKolicina(stavkaDTO.getKolicina());
		stavka.setPorudzbina(p);
		stavka.setArtikal(a);
		
		

        stavka = stavkaRepository.save(stavka);
        return new StavkaDTO(stavka);
    }
	
	

	@Override
	public void delete(Long id) {
		
		stavkaRepository.deleteById(id);

	}
	
	@Override
    public StavkaDTO update(Long id,StavkaDTO stavkaDTO) {
		
		Stavka stavka = stavkaRepository.findOneById(id);
		Porudzbina porudzbina = stavka.getPorudzbina();
		Artikal artikal = stavka.getArtikal();
		
		stavka.setKolicina(stavkaDTO.getKolicina());
		stavka.setPorudzbina(porudzbina);
		stavka.setArtikal(artikal);
		
		stavka = stavkaRepository.save(stavka);
		return new StavkaDTO(stavka);
	}

	@Override
	public List<StavkaDTO> findByArtikalAndPorudzbina(Long artikalId, Long porudzbinaId) {
		
		List<Stavka> stavka = stavkaRepository.findByArtikal_idAndPorudzbina_id(artikalId, porudzbinaId);
		
//		Stavka stavkaA = new Stavka();
//		stavkaA.setArtikal(artikalRepository.getOne(artikalId));
//		stavkaA.setPorudzbina(porudzbinaRepository.getOne(porudzbinaId));
//		stavkaA.setKolicina(stavkaDTO.getKolicina());
//		stavkaA = stavkaRepository.save(stavkaA);
		List<StavkaDTO> stavkaDTOs = new ArrayList<StavkaDTO>();
		
		for (Stavka stavkaa : stavka) {
			stavkaDTOs.add(new StavkaDTO(stavkaa));
		}
		return stavkaDTOs;
	}

	@Override
	public List<StavkeDTO> findByPorudzbina(Long porudzbinaId) {
		List<Stavka> stavka = stavkaRepository.findByPorudzbina_id(porudzbinaId);
		
		List<StavkeDTO> stavkaDTOs = new ArrayList<StavkeDTO>();
		
		for (Stavka stavkaa : stavka) {
			stavkaDTOs.add(new StavkeDTO(stavkaa));
		}
		return stavkaDTOs;
	}
	
	
	
	

}
