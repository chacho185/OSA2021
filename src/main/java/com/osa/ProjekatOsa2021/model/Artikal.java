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
	@JoinColumn(name="prodvac_id", referencedColumnName="id", nullable=false)
	private Prodavac prodavac;
	
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "artikal")
//	List<AkcijaArtikal> akcijeArtikli = new ArrayList<AkcijaArtikal>();
}
