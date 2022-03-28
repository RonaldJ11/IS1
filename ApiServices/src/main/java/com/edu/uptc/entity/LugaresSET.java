package com.edu.uptc.entity;

public class LugaresSET {
	private int id_lugar;
	private String tipo_lugar;
	private String direccion;
	private int FK_cli_list;
	
	
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
	public int getFK_cli_list() {
		return FK_cli_list;
	}
	public void setFK_cli_list(int fK_cli_list) {
		FK_cli_list = fK_cli_list;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
}
