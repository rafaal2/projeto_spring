package br.com.projeto.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupMathOp extends RuntimeException{
	
	public UnsupMathOp(String ex) {
		super(ex);
	}
	
	
	private static final long serialVersionUID = 1L;
}
