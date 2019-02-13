package br.edu.ifpr.consultacondutor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Veiculo {
	private @Id @GeneratedValue Long id;
	private String Description;
	private String RegistrationYear;
	private String Location;
	private String Colour;
	private String Power;
	private String EngineCC;
	private String Type;
	private String Seats;
	
	public Veiculo() {}

	public Veiculo(Long id, String description, String registrationYear, String location, String colour, String power,
			String engineCC, String type, String seats) {
		super();
		this.id = id;
		Description = description;
		RegistrationYear = registrationYear;
		Location = location;
		Colour = colour;
		Power = power;
		EngineCC = engineCC;
		Type = type;
		Seats = seats;
	}
}
