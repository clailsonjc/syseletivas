package com.sys.eletivas.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sys.eletivas.domain.Aluno;
import com.sys.eletivas.repositories.AlunoRepository;
import com.sys.eletivas.services.exceptions.MyObjectNotFoundException;

@Service
public class AlunoService {

	@Autowired
	AlunoRepository repo;

	public Aluno buscar(Integer id) {

		Optional<Aluno> obj = repo.findById(id);
		return obj.orElseThrow(() -> new MyObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Aluno.class.getName()));
	}

}//
