package br.edu.ifpr.consultacondutor.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import br.edu.ifpr.consultacondutor.service.PlacaAPIService;
import lombok.Data;

@Data
@Entity
public class Condutor {	
	private @Id @GeneratedValue Long id;
	private String name;
	private String cpf;
	
	@JoinColumn(name = "placas", referencedColumnName = "id") @OneToMany(cascade = CascadeType.ALL)
	private List<Placa> placas;
	
	@JoinColumn(name = "veiculos", referencedColumnName = "id") @OneToMany(cascade = CascadeType.ALL)
	private List<Veiculo> veiculos;
	
	public Condutor() {}
		
	public Condutor(String name, String cpf, List<Placa> placas) {
		this.name = name;
		this.cpf = cpf;
		this.placas = placas;
		this.setVeiculos(placas);	
	}
	
	public void setVeiculos(List<Placa> placas) {
		veiculos = new ArrayList<>();

		PlacaAPIService service = new PlacaAPIService();
		Gson gson = new Gson();
		for(Placa placa : placas) {
			try {
				veiculos.add(gson.fromJson(service.getResponse(placa), Veiculo.class));
			} catch (JsonSyntaxException | SAXException | IOException | ParserConfigurationException e) {
				e.printStackTrace();
			}
		}
	}
}
