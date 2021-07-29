package com.bcp.tcambio.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcp.tcambio.dao.TarifarioDao;
import com.bcp.tcambio.dto.TipoCambioInputDto;
import com.bcp.tcambio.dto.TipoCambioOutputDto;
import com.bcp.tcambio.model.Tarifario;
import com.bcp.tcambio.service.TipoCambioService;

@Service
public class TipoCambioServiceImpl implements TipoCambioService{

	@Autowired
	TarifarioDao tarifarioDao;
	
	@Override
	public TipoCambioOutputDto aplicaTipoCambio(TipoCambioInputDto tipoCambioInputDto) {
		
		String codigo = tipoCambioInputDto.getMonedaOrigen().concat(tipoCambioInputDto.getMonedaDestino());
		return obtenerTotal(tarifarioDao.findByCodigo(codigo), tipoCambioInputDto);
		
	}
	
	private TipoCambioOutputDto obtenerTotal(Tarifario tarifario, TipoCambioInputDto tipoCambioInputDto) {
		TipoCambioOutputDto tipoCambioOutputDto = new TipoCambioOutputDto();
		tipoCambioOutputDto.setMonedaOrigen(tipoCambioInputDto.getMonedaOrigen());
		tipoCambioOutputDto.setMonedaDestino(tipoCambioInputDto.getMonedaDestino());
		tipoCambioOutputDto.setMonto(tipoCambioInputDto.getMonto());
		
		tipoCambioOutputDto.setTipoCambio(tarifario.getFactor());
		BigDecimal montoTipoCambio = tipoCambioInputDto.getMonto().multiply(tarifario.getFactor());
		
		tipoCambioOutputDto.setMontoTipoCambio(montoTipoCambio);
		
		return tipoCambioOutputDto;
	}

}
