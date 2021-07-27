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
@Table(name = "porudzbine")
public class Porudzbina {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
	
	@Column(name = "satnica", nullable = false)
	private Date satnica;
	
	@Column(name = "dostavljeno")
	private Boolean dostavljeno;
	
	@Column(name = "ocena", nullable = false)
	private Integer ocena;
	
	@Column(name = "komentar", nullable = false)
	private String komentar;
	
	@Column(name = "anonimiKomentar")
	private Boolean anonimiKomentar;
	
	@Column(name = "arhiviraniKomentar")
	private Boolean arhiviraniKomentar;
	
	@ManyToOne
	@JoinColumn(name="kupac_id", referencedColumnName="id", nullable=false)
	private Kupac kupac;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "porudzbina")
	private List<Stavka> stavke = new ArrayList<Stavka>();

	public Porudzbina(Long id, Date satnica, Boolean dostavljeno, Integer ocena, String komentar,
			Boolean anonimiKomentar, Boolean arhiviraniKomentar, Kupac kupac, List<Stavka> stavke) {
		super();
		this.id = id;
		this.satnica = satnica;
		this.dostavljeno = dostavljeno;
		this.ocena = ocena;
		this.komentar = komentar;
		this.anonimiKomentar = anonimiKomentar;
		this.arhiviraniKomentar = arhiviraniKomentar;
		this.kupac = kupac;
		this.stavke = stavke;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getSatnica() {
		return satnica;
	}

	public void setSatnica(Date satnica) {
		this.satnica = satnica;
	}

	public Boolean getDostavljeno() {
		return dostavljeno;
	}

	public void setDostavljeno(Boolean dostavljeno) {
		this.dostavljeno = dostavljeno;
	}

	public Integer getOcena() {
		return ocena;
	}

	public void setOcena(Integer ocena) {
		this.ocena = ocena;
	}

	public String getKomentar() {
		return komentar;
	}

	public void setKomentar(String komentar) {
		this.komentar = komentar;
	}

	public Boolean getAnonimiKomentar() {
		return anonimiKomentar;
	}

	public void setAnonimiKomentar(Boolean anonimiKomentar) {
		this.anonimiKomentar = anonimiKomentar;
	}

	public Boolean getArhiviraniKomentar() {
		return arhiviraniKomentar;
	}

	public void setArhiviraniKomentar(Boolean arhiviraniKomentar) {
		this.arhiviraniKomentar = arhiviraniKomentar;
	}

	public Kupac getKupac() {
		return kupac;
	}

	public void setKupac(Kupac kupac) {
		this.kupac = kupac;
	}

	public List<Stavka> getStavke() {
		return stavke;
	}

	public void setStavke(List<Stavka> stavke) {
		this.stavke = stavke;
	}

	

}