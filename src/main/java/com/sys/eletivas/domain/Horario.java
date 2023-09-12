package com.sys.eletivas.domain;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sys.eletivas.domain.enums.Aula;
import com.sys.eletivas.domain.enums.DiaDaSemana;
import com.sys.eletivas.domain.enums.Semestre;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Horario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
			
	private Integer ano;	
	private Integer vagas;
	
	// dia, aula, semestre  serão ENUNS
	private Integer dia;
	private Integer aula;
	private Integer semestre;
	
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_eletiva")
	private Eletiva eletiva;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_professor")
	private Professor professor;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_local")
	private Local local;
	
	
	public Horario() {
	}		
	
	//construtor 
	public Horario(Integer id, Integer ano, Integer vagas, DiaDaSemana dia, Aula aula, Semestre semestre,
			Eletiva eletiva, Professor professor, Local local) {
		super();
		this.id = id;
		this.ano = ano;
		this.vagas = vagas;
		this.dia = dia.getCod();
		this.aula = aula.getCod();
		this.semestre = semestre.getCod();
		this.eletiva = eletiva;
		this.professor = professor;
		this.local = local;
	}
	
	//geters e seters
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getAno() {
		return ano;
	}


	public void setAno(Integer ano) {
		this.ano = ano;
	}


	public Integer getVagas() {
		return vagas;
	}


	public void setVagas(Integer vagas) {
		this.vagas = vagas;
	}


	public DiaDaSemana getDia() {
		return DiaDaSemana.toEnum(dia);
	}


	public void setDia(DiaDaSemana dia) {
		this.dia = dia.getCod();
	}


	public Aula getAula() {
		return Aula.toEnum(aula);
	}


	public void setAula(Aula aula) {
		this.aula = aula.getCod();
	}


	public Semestre getSemestre() {
		return Semestre.toEnum(semestre);
	}


	public void setSemestre(Semestre semestre) {
		this.semestre = semestre.getCod();
	}


	public Eletiva getEletiva() {
		return eletiva;
	}


	public void setEletiva(Eletiva eletiva) {
		this.eletiva = eletiva;
	}


	public Professor getProfessor() {
		return professor;
	}


	public void setProfessor(Professor professor) {
		this.professor = professor;
	}


	public Local getLocal() {
		return local;
	}


	public void setLocal(Local local) {
		this.local = local;
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
		Horario other = (Horario) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	

}
