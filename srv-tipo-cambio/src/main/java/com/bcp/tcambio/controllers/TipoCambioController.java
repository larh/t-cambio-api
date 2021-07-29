package com.bcp.tcambio.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import com.bcp.tcambio.dto.TipoCambioInputDto;
import com.bcp.tcambio.dto.TipoCambioOutputDto;
import com.bcp.tcambio.service.TipoCambioService;

import reactor.core.publisher.Mono;

@RestController
public class TipoCambioController {
		
	@Autowired
	TipoCambioService tipoCambioService;
	
	@GetMapping("/tipo-cambio")
	public Mono<TipoCambioOutputDto> aplicarTipoCambio(@Valid @ModelAttribute TipoCambioInputDto tipoCambioInputDto) {
		return tipoCambioService.aplicaTipoCambio(tipoCambioInputDto);
	}
	
	
}
