package com.osa.ProjekatOsa2021.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.osa.ProjekatOsa2021.model.Stavka;

public interface StavkaRepository extends JpaRepository<Stavka, Long> {
	
	public Stavka findOneById(Long id);

}
