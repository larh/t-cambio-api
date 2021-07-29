package com.bcp.tcambio.dao;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.bcp.tcambio.model.Tarifario;

import reactor.core.publisher.Mono;

public interface TarifarioDao extends ReactiveCrudRepository<Tarifario, Long>{
	Mono<Tarifario> findByOrigenAndDestino(String origen, String destino);
	Mono<Tarifario> findByCodigo(String codigo);
}
