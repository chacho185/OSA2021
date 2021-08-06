package com.osa.ProjekatOsa2021.dto;

import com.osa.ProjekatOsa2021.model.Kupac;
import com.osa.ProjekatOsa2021.model.Prodavac;

public class KupacDTO {
	
	private Integer id;
	private String adresa;
	private String ime;
	private String prezime;
	private String korisnickoIme;
	private String lozinka;
	private Boolean blokiran;
	
	
	public KupacDTO(Integer id, String adresa, String ime, String prezime, String korisnickoIme, String lozinka,
			Boolean blokiran) {
		super();
		this.id = id;
		this.adresa = adresa;
		this.ime = ime;
		this.prezime = prezime;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.blokiran = blokiran;
	}
	
	public KupacDTO(Kupac k) {
		this(k.getId(), k.getAdresa(), k.getIme(), k.getPrezime(), k.getPassword(), k.getUsername(), k.getBlokiran());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public Boolean getBlokiran() {
		return blokiran;
	}

	public void setBlokiran(Boolean blokiran) {
		this.blokiran = blokiran;
	}
	
	
	
	
	
	
	

}
