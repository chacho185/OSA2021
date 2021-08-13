package com.osa.ProjekatOsa2021.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.osa.ProjekatOsa2021.model.Artikal;

public interface ArtikalRepository extends JpaRepository<Artikal, Long> {

	public Artikal findOneById(Long id);
	
	public List<Artikal> findByProdavac_id(Long id);
}
