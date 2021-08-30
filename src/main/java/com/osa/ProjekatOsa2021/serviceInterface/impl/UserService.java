package com.osa.ProjekatOsa2021.serviceInterface.impl;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.osa.ProjekatOsa2021.model.Admin;
import com.osa.ProjekatOsa2021.model.Kupac;
import com.osa.ProjekatOsa2021.model.Prodavac;
import com.osa.ProjekatOsa2021.repository.AdminRepository;
import com.osa.ProjekatOsa2021.repository.KupacRepository;
import com.osa.ProjekatOsa2021.repository.ProdavacRepository;
import com.osa.ProjekatOsa2021.security.CustomPrincipal;
import com.osa.ProjekatOsa2021.serviceInterface.UserServiceInterface;
import com.sun.el.stream.Optional;

@Service
public class UserService implements UserServiceInterface{
	
	
	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	ProdavacRepository prodavacRepository;
	
	@Autowired
	KupacRepository kupacRepository;
	
	
	
	@Override
	public UserDetails login(String username, String password) {
		java.util.Optional<Admin> admin = adminRepository.findOneByUsernameAndPassword(username, password);
		java.util.Optional<Kupac> kupac = kupacRepository.findOneByUsernameAndPassword(username, password);
		java.util.Optional<Prodavac> prodavac = prodavacRepository.findOneByUsernameAndPassword(username, password);
		
		if(admin.isPresent() ) {
			
	        Admin u = admin.get();
	        
	        return new CustomPrincipal(u.getId(), u.getUsername(), u.getIme(), u.getPrezime(), u.getPassword(), new HashSet<>());

		}
		else if(kupac.isPresent()) {
			
	        Kupac u = kupac.get();
	        
	        return new CustomPrincipal(u.getId(), u.getUsername(), u.getIme(), u.getPrezime(), u.getPassword(), new HashSet<>());

		}
		
		else if(prodavac.isPresent()) {
			
	        Prodavac u = prodavac.get();
	        
			 return new CustomPrincipal(u.getId(), u.getUsername(), u.getIme(), u.getPrezime(), u.getPassword(), new HashSet<>());


		}
		return null;
		 //return new CustomPrincipal(u.getId(), u.getUsername(), u.getFirstName(), u.getLastName(), u.getPassword(), new HashSet<>());
		
	}
}
