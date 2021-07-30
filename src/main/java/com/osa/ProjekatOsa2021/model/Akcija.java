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
}
