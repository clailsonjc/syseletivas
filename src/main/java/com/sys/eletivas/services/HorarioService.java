package com.sys.eletivas.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sys.eletivas.domain.Horario;
import com.sys.eletivas.repositories.HorarioRepository;
import com.sys.eletivas.services.exceptions.MyObjectNotFoundException;

@Service
public class HorarioService {

	@Autowired
	HorarioRepository repo;

	public Horario buscar(Integer id) {

		Optional<Horario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new MyObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Horario.class.getName()));
	}

}//
