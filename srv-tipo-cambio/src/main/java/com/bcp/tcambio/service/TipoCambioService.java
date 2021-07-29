package com.bcp.tcambio.service;

import com.bcp.tcambio.dto.TipoCambioInputDto;
import com.bcp.tcambio.dto.TipoCambioOutputDto;

public interface TipoCambioService {
	TipoCambioOutputDto aplicaTipoCambio(TipoCambioInputDto tipoCambioInputDto);
}
