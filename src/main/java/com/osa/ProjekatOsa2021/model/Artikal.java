package com.osa.ProjekatOsa2021.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "artikli")
public class Artikal {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
	
	@Column(name = "naziv", nullable = false)
	private String naziv;
	
	@Column(name = "opis", nullable = false)
	private String opis;
	
	@Column(name = "cena", nullable = false)
	private Double cena;
	
	@Column(name = "putanjaSlike", nullable = false)
	private String putanjaSlike;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "artikal")
	private List<Stavka> stavke = new ArrayList<Stavka>();
	
	@ManyToOne
	@JoinColumn(name="prodvac_id", referencedColumnName="id", nullable = false)
	private Prodavac prodavac;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "artikal")
	List<AkcijaArtikal> akcijeArtikli = new ArrayList<AkcijaArtikal>();

	public Artikal() {
		super();
		this.id = 0L;
		this.naziv = "";
		this.opis = "";
		this.cena = 0.0;
		this.putanjaSlike = "";
		this.prodavac = new Prodavac();
		
	}
	
	
	public Artikal(Long id, String naziv, String opis, Double cena, String putanjaSlike, List<Stavka> stavke,
			Prodavac prodavac, List<AkcijaArtikal> akcijeArtikli) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.opis = opis;
		this.cena = cena;
		this.putanjaSlike = putanjaSlike;
		this.stavke = stavke;
		this.prodavac = prodavac;
		this.akcijeArtikli = akcijeArtikli;
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

	public List<Stavka> getStavke() {
		return stavke;
	}

	public void setStavke(List<Stavka> stavke) {
		this.stavke = stavke;
	}

	public Prodavac getProdavac() {
		return prodavac;
	}

	public void setProdavac(Prodavac prodavac) {
		this.prodavac = prodavac;
	}

	public List<AkcijaArtikal> getAkcijeArtikli() {
		return akcijeArtikli;
	}

	public void setAkcijeArtikli(List<AkcijaArtikal> akcijeArtikli) {
		this.akcijeArtikli = akcijeArtikli;
	}

	
}
