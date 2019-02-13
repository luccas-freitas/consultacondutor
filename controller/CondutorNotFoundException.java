package br.edu.ifpr.consultacondutor.controller;

public class CondutorNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public CondutorNotFoundException(Long id) {
		super("Condutor " + id + " não encontrado.");
	}
}
