package com.osa.ProjekatOsa2021.dto;

import java.util.Date;

import com.osa.ProjekatOsa2021.model.Akcija;


public class AkcijaDTO {
	
	private Long id;
	private Integer procenat;
	private Date odKad;
	private Date doKad;
	private String tekst;
	private ProdavacDTO prodavacDTO;
	
	
	public AkcijaDTO(Long id, Integer procenat, Date odKad, Date doKad, String tekst, ProdavacDTO prodavacDTO) {
		super();
		this.id = id;
		this.procenat = procenat;
		this.odKad = odKad;
		this.doKad = doKad;
		this.tekst = tekst;
		this.prodavacDTO = prodavacDTO;
	}
	
	
	public AkcijaDTO(Akcija a) {
		this(a.getId(), a.getProcenat(), a.getOdKad(), a.getDoKad(), a.getTekst(), new ProdavacDTO(a.getProdavac()));
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


	public ProdavacDTO getProdavacDTO() {
		return prodavacDTO;
	}


	public void setProdavacDTO(ProdavacDTO prodavacDTO) {
		this.prodavacDTO = prodavacDTO;
	}
	
	
	
	
	

}
