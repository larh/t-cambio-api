package com.bcp.tcambio.service;

import java.util.List;

import com.bcp.tcambio.model.Tarifario;

public interface TarifarioService {
	
	Tarifario addTarifario(Tarifario tarifario);
	List<Tarifario> listarTarifario();
	Tarifario getTarifario(String codigo);
	
}
