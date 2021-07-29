package com.bcp.tcambio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bcp.tcambio.model.Tarifario;
import com.bcp.tcambio.service.TarifarioService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class TarifarioController {
	
	@Autowired
	TarifarioService tarifarioService;
	
	@GetMapping("/tarifario")
	public Flux<Tarifario> getAllTarifarios() {
		return tarifarioService.listarTarifario();
	}
	
	@GetMapping("/tarifario/{codigo}")
	public Mono<Tarifario> getTarifario(@PathVariable String codigo) {
		return tarifarioService.getTarifario(codigo);
	}
	
	@PostMapping("/tarifario")
	public Mono<Tarifario> addTarifario(@RequestBody Tarifario tarifario) {
		return tarifarioService.addTarifario(tarifario);
	}
	
}
