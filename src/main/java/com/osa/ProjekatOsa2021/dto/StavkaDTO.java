package com.osa.ProjekatOsa2021.dto;

import com.osa.ProjekatOsa2021.model.Akcija;
import com.osa.ProjekatOsa2021.model.Stavka;

public class StavkaDTO {

	private Long id;
	private Integer kolicina;
	private Long porudzbinaDTO;
	private Long artikalDTO;
	
	
	public StavkaDTO(Long id, Integer kolicina, Long porudzbinaDTO, Long artikalDTO) {
		super();
		this.id = id;
		this.kolicina = kolicina;
		this.porudzbinaDTO = porudzbinaDTO;
		this.artikalDTO = artikalDTO;
	}
	
	public StavkaDTO() {
		super();
		
	}
	
	public StavkaDTO(Stavka s) {
		this(s.getId(), s.getKolicina(), s.getPorudzbina().getId(),s.getArtikal().getId());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getKolicina() {
		return kolicina;
	}

	public void setKolicina(Integer kolicina) {
		this.kolicina = kolicina;
	}

	public Long getPorudzbinaDTO() {
		return porudzbinaDTO;
	}

	public void setPorudzbinaDTO(Long porudzbinaDTO) {
		this.porudzbinaDTO = porudzbinaDTO;
	}

	public Long getArtikalDTO() {
		return artikalDTO;
	}

	public void setArtikalDTO(Long artikalDTO) {
		this.artikalDTO = artikalDTO;
	}
	
	
	
	
	
}
