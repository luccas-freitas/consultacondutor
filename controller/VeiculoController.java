package br.edu.ifpr.consultacondutor.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpr.consultacondutor.model.Veiculo;
import br.edu.ifpr.consultacondutor.repository.VeiculoRepository;

@RestController
public class VeiculoController {
	private final VeiculoRepository repository;
	
	public VeiculoController(VeiculoRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/veiculos")
	List<Veiculo> all() {
		return repository.findAll();
	}
	
	@PostMapping("/veiculos")
	Veiculo newCondutor(@RequestBody Veiculo veiculo) {
		return repository.save(veiculo);
	}
	
	@GetMapping("/veiculos/{id}")
	Veiculo one(@PathVariable Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new CondutorNotFoundException(id));
	}
	
	@PutMapping("/veiculos/{id}")
	Veiculo replaceCondutor(@RequestBody Veiculo newVeiculo, @PathVariable Long id) {
		return repository.findById(id)
				.map(veiculo -> {
					veiculo.setDescription(newVeiculo.getDescription());
					veiculo.setRegistrationYear(newVeiculo.getRegistrationYear());
					veiculo.setLocation(newVeiculo.getLocation());
					veiculo.setColour(newVeiculo.getColour());
					veiculo.setPower(newVeiculo.getPower());
					veiculo.setEngineCC(newVeiculo.getEngineCC());
					veiculo.setType(newVeiculo.getType());
					veiculo.setSeats(newVeiculo.getSeats());
					
					return repository.save(veiculo);
				})
				.orElseGet(() -> {
					newVeiculo.setId(id);
					return repository.save(newVeiculo);
				});
				
	}
	
	@DeleteMapping("/veiculos/{id}")
	void deleteCondutor(@PathVariable Long id) {
		repository.deleteById(id);
	}

}
