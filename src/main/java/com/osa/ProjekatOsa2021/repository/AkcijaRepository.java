package com.osa.ProjekatOsa2021.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.osa.ProjekatOsa2021.model.Akcija;


public interface AkcijaRepository extends JpaRepository<Akcija, Long> {
	
	public Akcija findOneById(Long id);

}
