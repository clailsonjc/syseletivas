package com.sys.eletivas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sys.eletivas.domain.Aluno;
import com.sys.eletivas.dto.AlunoDTO;
import com.sys.eletivas.repositories.AlunoRepository;
import com.sys.eletivas.services.exceptions.MyDataIntegrityException;
import com.sys.eletivas.services.exceptions.MyObjectNotFoundException;

@Service
public class AlunoService {

	@Autowired
	AlunoRepository repo;

	public Aluno find(Integer id) {

		Optional<Aluno> obj = repo.findById(id);
		return obj.orElseThrow(() -> new MyObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Aluno.class.getName()));
	}

	// salvar
	public Aluno insert(Aluno obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	// atualiza
	public Aluno update(Aluno obj) {
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

	// listar todos
	public List<Aluno> findAll() {
		return repo.findAll();
	}

	// listar paginação
	public Page<Aluno> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		
		Sort sort = Sort.by(orderBy).ascending();		
		if( direction.equals("DESC"))sort = Sort.by(orderBy).descending();
		Pageable pageable = PageRequest.of(page, linesPerPage, sort);
		return repo.findAll(pageable);

	}
	
	public Aluno fromDTO(AlunoDTO objDTO) {
		
		return new Aluno(objDTO.getId(),objDTO.getMatrícula(),objDTO.getNome(), 
				objDTO.getSexo(), objDTO.getSenha());
		
	}
	
	
	
	

}//
