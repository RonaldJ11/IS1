package com.edu.uptc.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "agendamientos")
public class Agendamientos implements Serializable{

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 7265312506817554632L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_agendamiento;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Clientes FK_cli_ag;

	@ManyToOne
	@JoinColumn(name = "id_servicio")
	private Servicios FK_servicios;

	private double duracion_servicio;
	private Date fecha_ingreso;
	private String frecuencia;
	private String hora_inicio;
	private String hora_fin;
	private String turno ;
	
	
	public int getId_agendamiento() {
		return id_agendamiento;
	}
	public void setId_agendamiento(int id_agendamiento) {
		this.id_agendamiento = id_agendamiento;
	}
	public Clientes getClientes() {
		return FK_cli_ag;
	}
	public void setClientes(Clientes clientes) {
		this.FK_cli_ag = clientes;
	}
	public Servicios getServicios() {
		return FK_servicios;
	}
	public void setServicios(Servicios servicios) {
		this.FK_servicios = servicios;
	}
	public double getDuracion_servicio() {
		return duracion_servicio;
	}
	public void setDuracion_servicio(double duracion_servicio) {
		this.duracion_servicio = duracion_servicio;
	}
	public Date getFecha_ingreso() {
		return fecha_ingreso;
	}
	public void setFecha_ingreso(Date fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}
	public String getFrecuencia() {
		return frecuencia;
	}
	public void setFrecuencia(String frecuencia) {
		this.frecuencia = frecuencia;
	}
	public String getHora_inicio() {
		return hora_inicio;
	}
	public void setHora_inicio(String hora_inicio) {
		this.hora_inicio = hora_inicio;
	}
	public String getHora_fin() {
		return hora_fin;
	}
	public void setHora_fin(String hora_fin) {
		this.hora_fin = hora_fin;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	
	
	

	
}
