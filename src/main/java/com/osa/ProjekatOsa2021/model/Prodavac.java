package com.osa.ProjekatOsa2021.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "prodavci")
public class Prodavac extends Korisnik {

	@Column(name = "poslujeOd", nullable = false)
	private Date poslujeOd;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "adresa", nullable = false)
	private String adresa;
	
	@Column(name = "naziv", nullable = false)
	private String naziv;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "prodavac")
	private List<Akcija> akcije = new ArrayList<Akcija>();
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "prodavac")
	private List<Artikal> artikli = new ArrayList<Artikal>();
	
	public Prodavac() {
		super();
		this.poslujeOd = new Date();
		this.email = "";
		this.adresa = "";
		this.naziv = "";
	}
	public Prodavac(Long id, String ime, String prezime, String username, String password, Boolean blokiran,
			Date poslujeOd, String email, String adresa, String naziv, List<Akcija> akcije, List<Artikal> artikli) {
		super(id, ime, prezime, username, password, blokiran);
		this.poslujeOd = poslujeOd;
		this.email = email;
		this.adresa = adresa;
		this.naziv = naziv;
		this.akcije = akcije;
		this.artikli = artikli;
	}

	public Date getPoslujeOd() {
		return poslujeOd;
	}

	public void setPoslujeOd(Date poslujeOd) {
		this.poslujeOd = poslujeOd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Akcija> getAkcije() {
		return akcije;
	}

	public void setAkcije(List<Akcija> akcije) {
		this.akcije = akcije;
	}

	public List<Artikal> getArtikli() {
		return artikli;
	}

	public void setArtikli(List<Artikal> artikli) {
		this.artikli = artikli;
	}
}
