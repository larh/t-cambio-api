package com.bcp.tcambio.service.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.bcp.tcambio.dto.TipoCambioInputDto;
import com.bcp.tcambio.dto.TipoCambioOutputDto;
import com.bcp.tcambio.model.Tarifario;
import com.bcp.tcambio.service.TipoCambioService;

import reactor.core.publisher.Mono;

@Service
public class TipoCambioServiceImpl implements TipoCambioService{

	private WebClient webClient;
	
	public TipoCambioServiceImpl(WebClient webClient) {
		super();
		this.webClient = webClient;
	}

	@Override
	public Mono<TipoCambioOutputDto> aplicaTipoCambio(TipoCambioInputDto tipoCambioInputDto) {
		
		String codigo = tipoCambioInputDto.getMonedaOrigen().concat(tipoCambioInputDto.getMonedaDestino());
		
		return webClient.get()
				.uri("/{codigo}", codigo)
				.retrieve()
				.bodyToMono(Tarifario.class)
				.map((tarif) -> obtenerTotal(tarif, tipoCambioInputDto));
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
