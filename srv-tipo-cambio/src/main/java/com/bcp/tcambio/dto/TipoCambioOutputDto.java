package com.bcp.tcambio.dto;

import java.math.BigDecimal;

public class TipoCambioOutputDto extends TipoCambioInputDto{
	
	private BigDecimal tipoCambio;
	private BigDecimal montoTipoCambio;
	
	public BigDecimal getTipoCambio() {
		return tipoCambio;
	}
	public void setTipoCambio(BigDecimal tipoCambio) {
		this.tipoCambio = tipoCambio;
	}
	public BigDecimal getMontoTipoCambio() {
		return montoTipoCambio;
	}
	public void setMontoTipoCambio(BigDecimal montoTipoCambio) {
		this.montoTipoCambio = montoTipoCambio;
	}
	
	
}
