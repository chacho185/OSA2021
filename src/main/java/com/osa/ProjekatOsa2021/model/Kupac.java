package com.osa.ProjekatOsa2021.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "kupci")
public class Kupac extends Korisnik {

	@Column(name = "adresa", nullable = false)
	private String adresa;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "kupac")
	private List<Porudzbina> porudzbine  = new ArrayList<Porudzbina>();

	public Kupac(Integer id, String ime, String prezime, String username, String password, Boolean blokiran, String adresa,
			List<Porudzbina> porudzbine) {
		super(id, ime, prezime, username, password, blokiran);
		this.adresa = adresa;
		this.porudzbine = porudzbine;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	
}
