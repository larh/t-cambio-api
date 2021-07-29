package com.bcp.tcambio.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcp.tcambio.dao.TarifarioDao;
import com.bcp.tcambio.model.Tarifario;
import com.bcp.tcambio.service.TarifarioService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TarifarioServiceImpl implements TarifarioService{

	@Autowired
	TarifarioDao tarifarioDao;

	@Override
	public Flux<Tarifario> listarTarifario() {
		return tarifarioDao.findAll();
	}

	@Override
	public Mono<Tarifario> addTarifario(Tarifario tarifario) {
		tarifario.setCodigo(tarifario.getOrigen().concat(tarifario.getDestino()));
		return tarifarioDao.save(tarifario);
	}

	@Override
	public Mono<Tarifario> getTarifario(String codigo) {
		return tarifarioDao.findByCodigo(codigo);
	}
	
}