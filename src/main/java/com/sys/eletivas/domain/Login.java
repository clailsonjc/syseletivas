package com.sys.eletivas.domain;

import java.io.Serializable;
import java.util.Objects;

public class Login implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String usuario;
	
	private String senha;

		
	//enum do tipo de usuario
	
	
	public Login() {
		
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
		Login other = (Login) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
}
