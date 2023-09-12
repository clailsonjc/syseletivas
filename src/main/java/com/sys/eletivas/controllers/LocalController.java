package com.sys.eletivas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sys.eletivas.domain.Local;
import com.sys.eletivas.services.LocalService;

@RestController
@RequestMapping(value = "/locais")
public class LocalController {
	
	@Autowired
	LocalService service;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
				
		Local obj = service.buscar(id);			
		return ResponseEntity.ok(obj) ;
				
		
	}
	
	@RequestMapping
	public String inicio() {
		return "Loal controller ok";
	}



	
	
	
	
}
