package com.osa.ProjekatOsa2021.dto;

import java.util.Date;

import com.osa.ProjekatOsa2021.model.Artikal;
import com.osa.ProjekatOsa2021.model.Kupac;
import com.osa.ProjekatOsa2021.model.Porudzbina;

public class PorudzbinaDTO {
	
	private Long id;
	private Date satnica;
	private Boolean dostavljeno;
	private Integer ocena;
	private String komentar;
	private Boolean anonimiKomentar;
	private Boolean arhiviraniKomentar;
	private Long kupacDTO;
	
	
	public PorudzbinaDTO(Long id, Date satnica, Boolean dostavljeno, Integer ocena, String komentar,
			Boolean anonimiKomentar, Boolean arhiviraniKomentar, Long kupacDTO) {
		super();
		this.id = id;
		this.satnica = satnica;
		this.dostavljeno = dostavljeno;
		this.ocena = ocena;
		this.komentar = komentar;
		this.anonimiKomentar = anonimiKomentar;
		this.arhiviraniKomentar = arhiviraniKomentar;
		this.kupacDTO = kupacDTO;
	}
	
	public PorudzbinaDTO(Porudzbina p) {
		this(p.getId(), p.getSatnica(), p.getDostavljeno(), p.getOcena(), p.getKomentar(), p.getAnonimiKomentar(),p.getArhiviraniKomentar(), p.getKupac().getId());
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

	public Long getKupacDTO() {
		return kupacDTO;
	}

	public void setKupacDTO(Long kupacDTO) {
		this.kupacDTO = kupacDTO;
	}
	
	
	
	
	

}
