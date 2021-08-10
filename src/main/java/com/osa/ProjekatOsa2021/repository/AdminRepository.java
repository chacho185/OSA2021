package com.osa.ProjekatOsa2021.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.osa.ProjekatOsa2021.model.Admin;
import com.osa.ProjekatOsa2021.model.Prodavac;

public interface AdminRepository extends JpaRepository<Admin, Long> {
	
	public Admin findOneById(Long id);

}
