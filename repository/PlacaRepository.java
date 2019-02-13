package br.edu.ifpr.consultacondutor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpr.consultacondutor.model.Placa;

public interface PlacaRepository extends JpaRepository<Placa, Long> {}
