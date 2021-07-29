package com.bcp.tcambio.service.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bcp.tcambio.dto.TipoCambioInputDto;
import com.bcp.tcambio.dto.TipoCambioOutputDto;
import com.bcp.tcambio.model.Tarifario;
import com.bcp.tcambio.service.TipoCambioService;

@Service
public class TipoCambioServiceImpl implements TipoCambioService{

	private RestTemplate restTemplate;
	
	public TipoCambioServiceImpl(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}

	@Override
	public TipoCambioOutputDto aplicaTipoCambio(TipoCambioInputDto tipoCambioInputDto) {
		
		String codigo = tipoCambioInputDto.getMonedaOrigen().concat(tipoCambioInputDto.getMonedaDestino());
		return obtenerTotal(restTemplate.getForObject("/{codigo}", Tarifario.class, codigo), tipoCambioInputDto);
		
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
