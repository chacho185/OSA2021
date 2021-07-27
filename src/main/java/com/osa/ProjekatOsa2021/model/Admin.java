package com.osa.ProjekatOsa2021.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "administratori")
public class Admin extends Korisnik {

	public Admin(Long id, String ime, String prezime, String username, String password, Boolean blokiran) {
		super(id, ime, prezime, username, password, blokiran);
		// TODO Auto-generated constructor stub
	}

}
