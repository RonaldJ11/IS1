package com.edu.uptc.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Clientes implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -314373059078332934L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_cliente;
	
	private String nombres;
	
	@OneToMany(mappedBy = "FK_cli_ag" , cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Agendamientos> agendamientos;
	
	@OneToMany(mappedBy = "FK_cli_list", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Lugares> direcciones;

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public List<Agendamientos> getAgendamientos() {
		return agendamientos;
	}

	public void setAgendamientos(List<Agendamientos> agendamientos) {
		this.agendamientos = agendamientos;
	}

	public List<Lugares> getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(List<Lugares> direcciones) {
		this.direcciones = direcciones;
	}
	
	
}
