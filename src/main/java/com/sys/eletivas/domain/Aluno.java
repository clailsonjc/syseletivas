package com.sys.eletivas.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Aluno implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
		
	private Integer matrícula;	
	private String nome;	
	private Integer sexo;	
	private String senha;
	
	//@JsonManagedReference
	@ManyToMany(mappedBy = "alunos")
	private List<Turma> turmas = new ArrayList<>();
	
	
	
	
	public Aluno() {
		
	}
		
	public Aluno(Integer idAluno, Integer matrícula, String nome, Integer sexo, String senha) {
		super();
		this.id = idAluno;
		this.matrícula = matrícula;
		this.nome = nome;
		this.sexo = sexo;
		this.senha = senha;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer idAluno) {
		this.id = idAluno;
	}
	public Integer getMatrícula() {
		return matrícula;
	}
	public void setMatrícula(Integer matrícula) {
		this.matrícula = matrícula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getSexo() {
		return sexo;
	}
	public void setSexo(Integer sexo) {
		this.sexo = sexo;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}
	
	
	
	


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(id, other.id);
	}

	
	
		

}
