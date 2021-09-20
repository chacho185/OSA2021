package com.osa.ProjekatOsa2021.dto;

public class ArtikalKupujemDTO {

	private Long id;
	private String naziv;
	private Double cena;
	private Integer kolicina;
	private Boolean kupujem;
	
	private ArtikalKupujemDTO() {
		super();
	}

	public ArtikalKupujemDTO(Long id, String naziv, Double cena, Integer kolicina, Boolean kupujem) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.cena = cena;
		this.kolicina = kolicina;
		this.kupujem = kupujem;
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

	public Double getCena() {
		return cena;
	}

	public void setCena(Double cena) {
		this.cena = cena;
	}

	public Integer getKolicina() {
		return kolicina;
	}

	public void setKolicina(Integer kolicina) {
		this.kolicina = kolicina;
	}

	public Boolean getKupujem() {
		return kupujem;
	}

	public void setKupujem(Boolean kupujem) {
		this.kupujem = kupujem;
	}
}
