package com.bcp.tcambio.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="tarifario")
public class Tarifario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tarifario_seq")
	@SequenceGenerator(name = "tarifario_seq", allocationSize = 1)
	private long id;
	
	@Column(name = "codigo")
	private String codigo;

	@Column(name = "origen")
	private String origen;

	@Column(name = "destino")
	private String destino;
	
	@Column(name = "factor")
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
