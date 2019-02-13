package br.edu.ifpr.consultacondutor.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.edu.ifpr.consultacondutor.model.Condutor;
import br.edu.ifpr.consultacondutor.model.Placa;
import br.edu.ifpr.consultacondutor.repository.CondutorRepository;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
class LoadDatabase {
	@Bean
	CommandLineRunner initDatabase(CondutorRepository repository) {
		return args -> {			
			List<Placa> placas = new ArrayList<>();
			placas.add(new Placa("ABT0302"));
			placas.add(new Placa("AWG0873"));
			
			log.info("Preloading "
				+ repository
				.save(new Condutor(
						"Luccas de Freitas Ferreira", 
						"09166819989", 
						placas)));
		};
	}
}
