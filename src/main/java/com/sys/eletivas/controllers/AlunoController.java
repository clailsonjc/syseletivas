package com.sys.eletivas.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sys.eletivas.domain.Aluno;
import com.sys.eletivas.dto.AlunoDTO;
import com.sys.eletivas.services.AlunoService;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoController {

	@Autowired
	AlunoService service;

	@GetMapping("/teste")
	public String inicio() {
		return "Aluno Controller ok";
	}

	@GetMapping("/{id}")
	public ResponseEntity<Aluno> find(@PathVariable Integer id) {

		Aluno obj = service.find(id);
		return ResponseEntity.ok(obj);
	}

	// salvar
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Aluno obj) {

		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	// atualizar
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody Aluno obj, @PathVariable Integer id) {

		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	// deletar
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {

		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping()
	public ResponseEntity<List<AlunoDTO>> findAll() {

		List<Aluno> list = service.findAll();
		//List<AlunoDTO> listDTO = list.stream().map(obj -> new AlunoDTO(obj)).collect(Collectors.toList()); metodo do video
		  List<AlunoDTO> listDTO = list.stream().map(obj -> new AlunoDTO(obj)).toList();
		
		return ResponseEntity.ok().body(listDTO);
	}
	
	
	
	
	
	
	

}//
