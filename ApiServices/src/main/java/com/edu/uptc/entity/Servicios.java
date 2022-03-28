package com.edu.uptc.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "servicios")
public class Servicios implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -950737106321202515L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_servicio;

	@ManyToOne
	@JoinColumn(name = "id")
	private Prestadores FK_prestador;

	@OneToMany(mappedBy = "FK_servicios")
	private List<Agendamientos> agendamientos;

	private String descripcion;
	
	private String tipo_agendamiendo;
	
	private String suplementos;

	public int getId_servicio() {
		return id_servicio;
	}

	public void setId_servicio(int id_servicio) {
		this.id_servicio = id_servicio;
	}

	public Prestadores getPrestador() {
		return FK_prestador;
	}

	public void setPrestador(Prestadores prestador) {
		this.FK_prestador = prestador;
	}

	public List<Agendamientos> getAgendamientos() {
		return agendamientos;
	}

	public void setAgendamientos(List<Agendamientos> agendamientos) {
		this.agendamientos = agendamientos;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipo_agendamiendo() {
		return tipo_agendamiendo;
	}

	public void setTipo_agendamiendo(String tipo_agendamiendo) {
		this.tipo_agendamiendo = tipo_agendamiendo;
	}

	public String getSuplementos() {
		return suplementos;
	}

	public void setSuplementos(String suplementos) {
		this.suplementos = suplementos;
	}
	
}
