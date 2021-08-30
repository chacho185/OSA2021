package com.osa.ProjekatOsa2021.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.osa.ProjekatOsa2021.dto.StavkaDTO;
import com.osa.ProjekatOsa2021.model.Stavka;

public interface StavkaRepository extends JpaRepository<Stavka, Long> {
	
	public Stavka findOneById(Long id);
	
	public List<Stavka> findByArtikal_idAndPorudzbina_id(Long artikalId,Long porudzbinaId);

}
