package com.osa.ProjekatOsa2021.dto;

import com.osa.ProjekatOsa2021.model.Stavka;

public class StavkeDTO {

	private Long id;
	private Integer kolicina;
	private Long porudzbinaDTO;
	private ArtikalDTO artikalDTO;
//	private Double ukupaCena;
	
	public StavkeDTO(Long id, Integer kolicina, Long porudzbinaDTO, ArtikalDTO artikalDTO) {
		super();
		this.id = id;
		this.kolicina = kolicina;
		this.porudzbinaDTO = porudzbinaDTO;
		this.artikalDTO = artikalDTO;
//		this.ukupaCena = ukupnaCena;
	}
	
	public StavkeDTO() {
		super();
		
	}
	
	public StavkeDTO(Stavka s) {
		this(s.getId(), s.getKolicina(), s.getPorudzbina().getId(), new ArtikalDTO(s.getArtikal()));
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

	public ArtikalDTO getArtikalDTO() {
		return artikalDTO;
	}

	public void setArtikalDTO(ArtikalDTO artikalDTO) {
		this.artikalDTO = artikalDTO;
	}

//	public Double getUkupaCena() {
//		return ukupaCena;
//	}
//
//	public void setUkupaCena(Double ukupaCena) {
//		this.ukupaCena = ukupaCena;
//	}
	
	
}
