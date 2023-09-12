package com.sys.eletivas.domain.enums;

public enum DiaDaSemana {
	
	SEGUNDA(1, "SEGUNDA-FEIRA"),
	TERÇA(2,"TERÇA-FEIRA"),
	QUARTA(3,"QUARTA-FEIRA"),
	QUINTA(4,"QUINTA-FEIRA"),
	SEXTA(5,"SEXTA-FEIRA");
	
	private int cod;
	private String descricao;
	
	private DiaDaSemana(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	
	public static DiaDaSemana toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		
		for (DiaDaSemana x : DiaDaSemana.values()) {
			if(cod.equals(x.getCod())){
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id do Enum inválido:"+cod);
	}
	
	
	
}//
