package com.sys.eletivas.services.exceptions;




public class MyDataIntegrityException extends RuntimeException  {

	private static final long serialVersionUID = 1L;
	
	public MyDataIntegrityException(String msg) {
		super(msg);
	}
	
	public MyDataIntegrityException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
	

}
