package com.sys.eletivas.dmain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Aluno implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAluno;
	
	private Long matrícula;
	
	private String nome;
	
	private Integer sexo;
	
	private String senha;
	
	public Aluno(Long idAluno, Long matrícula, String nome, Integer sexo, String senha) {
		super();
		this.idAluno = idAluno;
		this.matrícula = matrícula;
		this.nome = nome;
		this.sexo = sexo;
		this.senha = senha;
	}
	
		
	public Long getIdAluno() {
		return idAluno;
	}
	public void setIdAluno(Long idAluno) {
		this.idAluno = idAluno;
	}
	public Long getMatrícula() {
		return matrícula;
	}
	public void setMatrícula(Long matrícula) {
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


	@Override
	public int hashCode() {
		return Objects.hash(idAluno);
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
		return Objects.equals(idAluno, other.idAluno);
	}
	
		

}
