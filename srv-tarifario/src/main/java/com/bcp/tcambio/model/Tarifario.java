package com.bcp.tcambio.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(value="tarifario")
public class Tarifario {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tarifario_seq")
//	@SequenceGenerator(name = "tarifario_seq", allocationSize = 1)
	private long id;
	
	@Column(value = "codigo")
	private String codigo;

	@Column(value = "origen")
	private String origen;

	@Column(value = "destino")
	private String destino;
	
	@Column(value = "factor")
	private BigDecimal factor;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public BigDecimal getFactor() {
		return factor;
	}

	public void setFactor(BigDecimal factor) {
		this.factor = factor;
	}
	
	
}
