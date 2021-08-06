package com.osa.ProjekatOsa2021.model;

import java.util.ArrayList;
import java.util.Date;
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
@Table(name = "akcije")
public class Akcija {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
	
	@Column(name = "procenat", nullable = false)
	private Integer procenat;
	
	@Column(name = "odKad", nullable = false)
	private Date odKad;
	
	@Column(name = "doKad", nullable = false)
	private Date doKad;
	
	@Column(name = "tekst", nullable = false)
	private String tekst;
	
	@ManyToOne
	@JoinColumn(name="prodavac_id", referencedColumnName="id", nullable=false)
	private Prodavac prodavac;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "akcija")
	List<AkcijaArtikal> akcijeArtikli = new ArrayList<AkcijaArtikal>();
	
	public Akcija() {
		super();
		this.id = 0L;
		this.procenat = 0;
		this.odKad = new Date();
		this.doKad = new Date();
		this.tekst = "";
		this.prodavac = new Prodavac();
	}

	public Akcija(Long id, Integer procenat, Date odKad, Date doKad, String tekst, Prodavac prodavac,
			List<AkcijaArtikal> akcijeArtikli) {
		super();
		this.id = id;
		this.procenat = procenat;
		this.odKad = odKad;
		this.doKad = doKad;
		this.tekst = tekst;
		this.prodavac = prodavac;
		this.akcijeArtikli = akcijeArtikli;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getProcenat() {
		return procenat;
	}

	public void setProcenat(Integer procenat) {
		this.procenat = procenat;
	}

	public Date getOdKad() {
		return odKad;
	}

	public void setOdKad(Date odKad) {
		this.odKad = odKad;
	}

	public Date getDoKad() {
		return doKad;
	}

	public void setDoKad(Date doKad) {
		this.doKad = doKad;
	}

	public String getTekst() {
		return tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
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
