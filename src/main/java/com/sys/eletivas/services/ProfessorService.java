package com.sys.eletivas.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sys.eletivas.domain.Professor;
import com.sys.eletivas.repositories.ProfessorRepository;
import com.sys.eletivas.services.exceptions.MyObjectNotFoundException;

@Service
public class ProfessorService {

	@Autowired
	ProfessorRepository repo;

	public Professor buscar(Integer id) {

		Optional<Professor> obj = repo.findById(id);
		return obj.orElseThrow(() -> new MyObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Professor.class.getName()));
	}

}//
