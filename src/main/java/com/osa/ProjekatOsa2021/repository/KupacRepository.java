package com.osa.ProjekatOsa2021.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.osa.ProjekatOsa2021.model.Admin;
import com.osa.ProjekatOsa2021.model.Kupac;


public interface KupacRepository extends JpaRepository<Kupac, Long> {
	
	public Kupac findOneById(Long id);

	public Kupac findOneByUsername(String ime);

	public Optional<Kupac> findOneByUsernameAndPassword(String username,String password);

}
