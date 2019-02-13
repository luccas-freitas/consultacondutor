package br.edu.ifpr.consultacondutor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Placa {
	private @Id @GeneratedValue Long id;
	private String placa;
	
	public Placa() {}

	public Placa(String placa) {
		super();
		this.placa = placa;
	}
}
