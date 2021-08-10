package com.osa.ProjekatOsa2021.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.osa.ProjekatOsa2021.model.Porudzbina;

public interface PorudzbinaRepository extends JpaRepository<Porudzbina, Long> {
	
	public Porudzbina findOneById(Long id);

}
