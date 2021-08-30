package com.osa.ProjekatOsa2021.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.osa.ProjekatOsa2021.model.Admin;
import com.osa.ProjekatOsa2021.model.Prodavac;

public interface ProdavacRepository extends JpaRepository<Prodavac, Long> {
	
	public Prodavac findOneById(Long id);
	
	public Optional<Prodavac> findOneByUsernameAndPassword(String username,String password);

}
