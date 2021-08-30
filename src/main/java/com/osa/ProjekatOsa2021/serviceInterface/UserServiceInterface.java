package com.osa.ProjekatOsa2021.serviceInterface;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserServiceInterface {
	
	public UserDetails login(String username,String password);

}
