package com.osa.ProjekatOsa2021.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.osa.ProjekatOsa2021.model.Admin;
import com.osa.ProjekatOsa2021.model.Prodavac;
import com.sun.el.stream.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
	
	public Admin findOneById(Long id);
	
	public java.util.Optional<Admin> findOneByUsernameAndPassword(String username,String password);

}
