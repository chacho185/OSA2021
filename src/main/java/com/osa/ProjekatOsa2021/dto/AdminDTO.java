package com.osa.ProjekatOsa2021.dto;

import com.osa.ProjekatOsa2021.model.Admin;
import com.osa.ProjekatOsa2021.model.Kupac;

public class AdminDTO {
	
	private Long id;
	private String ime;
	private String prezime;
	private String korisnickoIme;
	private String lozinka;
	private Boolean blokiran;
	
	
	public AdminDTO(Long id, String ime, String prezime, String korisnickoIme, String lozinka, Boolean blokiran) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.blokiran = blokiran;
	}
	
	public AdminDTO(Admin a) {
		this(a.getId(), a.getIme(), a.getPrezime(), a.getPassword(), a.getUsername(), a.getBlokiran());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
