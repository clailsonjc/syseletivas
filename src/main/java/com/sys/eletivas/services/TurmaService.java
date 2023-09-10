package com.sys.eletivas.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sys.eletivas.domain.Turma;
import com.sys.eletivas.repositories.TurmaRepository;

@Service
public class TurmaService {
	
	@Autowired
    TurmaRepository repo;

	public Turma buscar(Integer id) {
		
		Optional<Turma> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	
}
