package com.sys.eletivas.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sys.eletivas.domain.Turma;
import com.sys.eletivas.repositories.TurmaRepository;
import com.sys.eletivas.services.exceptions.MyObjectNotFoundException;

@Service
public class TurmaService {
	
	@Autowired
    TurmaRepository repo;

	public Turma buscar(Integer id) {
		
		Optional<Turma> obj = repo.findById(id);
		return obj.orElseThrow(() -> new MyObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Turma.class.getName()));
	}
	
	
	
	public Turma insert(Turma obj) {
		obj.setIdTurma(null);
		return repo.save(obj);
	}
	
	
	
	
	
	
	
	
	
	
	
}//
