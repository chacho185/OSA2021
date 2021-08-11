package com.osa.ProjekatOsa2021.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osa.ProjekatOsa2021.dto.AdminDTO;
import com.osa.ProjekatOsa2021.dto.AkcijaDTO;
import com.osa.ProjekatOsa2021.dto.KupacDTO;
import com.osa.ProjekatOsa2021.dto.ProdavacDTO;
import com.osa.ProjekatOsa2021.model.Admin;
import com.osa.ProjekatOsa2021.model.Kupac;
import com.osa.ProjekatOsa2021.repository.AdminRepository;
import com.osa.ProjekatOsa2021.serviceInterface.AdminServiceInterface;
import com.osa.ProjekatOsa2021.serviceInterface.KupacServiceInterface;

@RestController
@RequestMapping(value = "api/admin")
public class AdminController {
	
	@Autowired
	AdminServiceInterface adminServiceInterface;
	
	@GetMapping
	public ResponseEntity<List<AdminDTO>> getAllAdmin() {
		
		return ResponseEntity.ok().body(adminServiceInterface.getAll());
	}
	
	@PostMapping
	public ResponseEntity<AdminDTO> saveAccount(@RequestBody AdminDTO adminDTO){
		
		return  ResponseEntity.ok().body(adminServiceInterface.save(adminDTO));
	}
	
	@GetMapping(value = "/{id}")
	
	public ResponseEntity<AdminDTO> getOneAdmin(@PathVariable("id") Long id ) throws Exception {
		
		return ResponseEntity.ok().body(adminServiceInterface.getById(id));
	}
	
	@DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable("id") Long id){
       adminServiceInterface.delete(id);
        return  ResponseEntity.noContent().build();
    }
	
	@PutMapping(value = "/{id}")
    public ResponseEntity<AdminDTO> updateAdmin(@RequestBody AdminDTO adminDTO, @PathVariable("id") Long id){
        try {
            adminServiceInterface.update(id,adminDTO);
            return  ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
