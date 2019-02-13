package br.edu.ifpr.consultacondutor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpr.consultacondutor.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {}
