package com.bcp.tcambio.service;

import com.bcp.tcambio.model.Tarifario;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TarifarioService {
	
	Mono<Tarifario> addTarifario(Tarifario tarifario);
	Flux<Tarifario> listarTarifario();
	Mono<Tarifario> getTarifario(String codigo);
	
}
