package com.sys.eletivas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.sys.eletivas.domain.Turma;
import com.sys.eletivas.repositories.TurmaRepository;
import com.sys.eletivas.services.exceptions.MyDataIntegrityException;
import com.sys.eletivas.services.exceptions.MyObjectNotFoundException;

@Service
public class TurmaService {

	@Autowired
	TurmaRepository repo;

	public Turma find(Integer id) {

		Optional<Turma> obj = repo.findById(id);
		return obj.orElseThrow(() -> new MyObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Turma.class.getName()));
	}

	// salvar
	public Turma insert(Turma obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	// atualiza
	public Turma update(Turma obj) {
		find(obj.getId());
		return repo.save(obj);
	}

	// delete
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new MyDataIntegrityException("Não é possível excluir objetos com dependências!");
		}
	}
	
	public List<Turma> findAll() {		
		return repo.findAll();
	}
	
	
	
	
	

}//
