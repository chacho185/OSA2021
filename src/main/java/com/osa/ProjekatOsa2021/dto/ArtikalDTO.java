package com.osa.ProjekatOsa2021.dto;

import com.osa.ProjekatOsa2021.model.Artikal;

public class ArtikalDTO {

	private Long id;
	private String naziv;
	private String opis;
	private Double cena;
	private String putanjaSlike;
	private Long prodavacDTO;
	
	public ArtikalDTO(Long id, String naziv, String opis, Double cena, String putanjaSlike, Long prodavacDTO) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.opis = opis;
		this.cena = cena;
		this.putanjaSlike = putanjaSlike;
		this.prodavacDTO = prodavacDTO;
	}
	
	public ArtikalDTO(Artikal a) {
		this(a.getId(), a.getNaziv(), a.getOpis(), a.getCena(), a.getPutanjaSlike(), a.getProdavac().getId());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Double getCena() {
		return cena;
	}

	public void setCena(Double cena) {
		this.cena = cena;
	}

	public String getPutanjaSlike() {
		return putanjaSlike;
	}

	public void setPutanjaSlike(String putanjaSlike) {
		this.putanjaSlike = putanjaSlike;
	}

	public Long getProdavacDTO() {
		return prodavacDTO;
	}

	public void setProdavacDTO(Long prodavacDTO) {
		this.prodavacDTO = prodavacDTO;
	}
}
