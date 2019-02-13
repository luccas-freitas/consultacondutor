package br.edu.ifpr.consultacondutor.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpr.consultacondutor.model.Condutor;
import br.edu.ifpr.consultacondutor.repository.CondutorRepository;

@RestController
public class CondutorController {
	private final CondutorRepository repository;
	
	public CondutorController(CondutorRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/condutores")
	List<Condutor> all() {
		return repository.findAll();
	}
	
	@PostMapping("/condutores")
	Condutor newCondutor(@RequestBody Condutor condutor) {
		return repository.save(new Condutor(
					condutor.getName(),
					condutor.getCpf(),
					condutor.getPlacas()
				));
	}
	
	@GetMapping("/condutores/{id}")
	Condutor one(@PathVariable Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new CondutorNotFoundException(id));
	}
	
	@PutMapping("/condutores/{id}")
	Condutor replaceCondutor(@RequestBody Condutor newCondutor, @PathVariable Long id) {
		return repository.findById(id)
				.map(condutor -> {
					condutor.setName(newCondutor.getName());
					condutor.setCpf(newCondutor.getCpf());
					condutor.setPlacas(newCondutor.getPlacas());
					condutor.setVeiculos(newCondutor.getPlacas());
					
					return repository.save(condutor);
				})
				.orElseGet(() -> {
					newCondutor.setId(id);
					return repository.save(newCondutor);
				});
	}
	
	@DeleteMapping("/condutores/{id}")
	void deleteCondutor(@PathVariable Long id) {
		repository.deleteById(id);
	}

}
