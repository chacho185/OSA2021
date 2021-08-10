package com.osa.ProjekatOsa2021.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.osa.ProjekatOsa2021.model.Kupac;


public interface KupacRepository extends JpaRepository<Kupac, Long> {
	
	public Kupac findOneById(Long id);

}
