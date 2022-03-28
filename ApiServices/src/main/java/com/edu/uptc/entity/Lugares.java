package com.edu.uptc.entity;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lugares")
public class Lugares implements Serializable{

	/**
	 * Version Id
	 */
	private static final long serialVersionUID = -8182289457177546750L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_lugar;

	@Column(length = 50)
	private String tipo_lugar;
	
	
	@Column(length = 50)
	private String direccion;
	
	
	@ManyToOne
	@JoinColumn(name = "id_cliente",nullable=true)
	private Clientes FK_cli_list;


	public int getId_lugar() {
		return id_lugar;
	}


	public void setId_lugar(int id_lugar) {
		this.id_lugar = id_lugar;
	}


	public String getTipo_lugar() {
		return tipo_lugar;
	}


	public void setTipo_lugar(String tipo_lugar) {
		this.tipo_lugar = tipo_lugar;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public Clientes getCliente() {
		return FK_cli_list;
	}


	public void setCliente(Clientes cliente) {
		this.FK_cli_list = cliente;
	}
	
	

	
	
}
