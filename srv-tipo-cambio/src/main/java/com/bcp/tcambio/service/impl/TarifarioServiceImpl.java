package com.bcp.tcambio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcp.tcambio.dao.TarifarioDao;
import com.bcp.tcambio.model.Tarifario;
import com.bcp.tcambio.service.TarifarioService;

@Service
public class TarifarioServiceImpl implements TarifarioService{

	@Autowired
	TarifarioDao tarifarioDao;

	@Override
	public List<Tarifario> listarTarifario() {
		return (List<Tarifario>) tarifarioDao.findAll();
	}

	@Override
	public Tarifario addTarifario(Tarifario tarifario) {
		tarifario.setCodigo(tarifario.getOrigen().concat(tarifario.getDestino()));
		return tarifarioDao.save(tarifario);
	}

	@Override
	public Tarifario getTarifario(String codigo) {
		return tarifarioDao.findByCodigo(codigo);
	}
	
}