package com.bcp.tcambio.service;

import com.bcp.tcambio.dto.TipoCambioInputDto;
import com.bcp.tcambio.dto.TipoCambioOutputDto;

import reactor.core.publisher.Mono;

public interface TipoCambioService {
	Mono<TipoCambioOutputDto> aplicaTipoCambio(TipoCambioInputDto tipoCambioInputDto);
}
