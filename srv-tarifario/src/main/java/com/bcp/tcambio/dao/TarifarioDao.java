package com.bcp.tcambio.dao;

import org.springframework.data.repository.CrudRepository;

import com.bcp.tcambio.model.Tarifario;

public interface TarifarioDao extends CrudRepository<Tarifario, Long>{
	Tarifario findByOrigenAndDestino(String origen, String destino);
	Tarifario findByCodigo(String codigo);
}
