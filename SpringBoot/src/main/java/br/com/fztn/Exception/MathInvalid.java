package br.com.fztn.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MathInvalid extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public MathInvalid(String exception) {
		super(exception);
	}
}
