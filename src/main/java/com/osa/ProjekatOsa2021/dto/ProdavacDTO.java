package com.osa.ProjekatOsa2021.dto;

import java.util.Date;

import com.osa.ProjekatOsa2021.model.Prodavac;

public class ProdavacDTO {

	private Integer id;
	private Date poslujeOd;
	private String email;
	private String adresa;
	private String naziv;
	private String ime;
	private String prezime;
	private String korisnickoIme;
	private String lozinka;
	private Boolean blokiran;
	
	

	public ProdavacDTO(Integer id, Date poslujeOd, String email, String adresa, String naziv, String ime,
			String prezime, String korisnickoIme, String lozinka, Boolean blokiran) {
		super();
		this.id = id;
		this.poslujeOd = poslujeOd;
		this.email = email;
		this.adresa = adresa;
		this.naziv = naziv;
		this.ime = ime;
		this.prezime = prezime;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.blokiran = blokiran;
	}


	public ProdavacDTO(Prodavac p) {
		this(p.getId(), p.getPoslujeOd(), p.getEmail(), p.getAdresa(), p.getNaziv(), p.getIme(), p.getPrezime(), p.getUsername(), p.getPassword(), p.getBlokiran());
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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