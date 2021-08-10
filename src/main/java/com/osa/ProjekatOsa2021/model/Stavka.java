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
@Table(name = "stavke")
public class Stavka {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
	
	@Column(name = "kolicina", nullable = false)
	private Integer kolicina;
	
	@ManyToOne
	@JoinColumn(name="porudzbina_id", referencedColumnName="id", nullable=false)
	private Porudzbina porudzbina;
	
	@ManyToOne
	@JoinColumn(name="artikal_id", referencedColumnName="id", nullable=false)
	private Artikal artikal;
	
	public Stavka() {
		super();
		this.id = 0L;
		this.kolicina = 0;
		this.porudzbina = new Porudzbina();
		this.artikal = new Artikal();
	}

	public Stavka(Long id, Integer kolicina, Porudzbina porudzbina, Artikal artikal) {
		super();
		this.id = id;
		this.kolicina = kolicina;
		this.porudzbina = porudzbina;
		this.artikal = artikal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getKolicina() {
		return kolicina;
	}

	public void setKolicina(Integer kolicina) {
		this.kolicina = kolicina;
	}

	public Porudzbina getPorudzbina() {
		return porudzbina;
	}

	public void setPorudzbina(Porudzbina porudzbina) {
		this.porudzbina = porudzbina;
	}

	public Artikal getArtikal() {
		return artikal;
	}

	public void setArtikal(Artikal artikal) {
		this.artikal = artikal;
	}

	
}
