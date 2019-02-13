package br.edu.ifpr.consultacondutor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ifpr.consultacondutor.model.Condutor;

public interface CondutorRepository extends JpaRepository<Condutor, Long> {}
