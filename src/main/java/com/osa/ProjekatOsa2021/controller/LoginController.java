package com.osa.ProjekatOsa2021.controller;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.osa.ProjekatOsa2021.dto.AdminDTO;
import com.osa.ProjekatOsa2021.dto.JwtDTO;
import com.osa.ProjekatOsa2021.dto.LoginDTO;

import com.osa.ProjekatOsa2021.security.util.JwtUtil;
import com.osa.ProjekatOsa2021.serviceInterface.UserServiceInterface;

@RestController
@RequestMapping(value = "api")
public class LoginController {
	
	@Autowired
	UserServiceInterface userServiceInterface;
	
	
	
	@Autowired
    JwtUtil jwtUtil;
	
	
	
	
	
	@PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginRequest){
        UserDetails details = userServiceInterface.login(loginRequest.getUsername(), loginRequest.getPassword());
        String jwt = jwtUtil.generateToken(details);
        return new ResponseEntity<>(jwt, HttpStatus.OK);
    }
	
}
	
	


