package br.edu.ifpr.consultacondutor.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CondutorNotFoundAdvice {
	@ResponseBody
	@ExceptionHandler(CondutorNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String condutorNotFoundHandler (CondutorNotFoundException ex) {
		return ex.getMessage();
	}
}
