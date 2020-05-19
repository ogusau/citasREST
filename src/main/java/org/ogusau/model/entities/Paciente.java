package org.ogusau.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Paciente")
@PrimaryKeyJoinColumn(name = "ID_PACIENTE_USUARIO")
public class Paciente extends Usuario implements Serializable{

	private static final long serialVersionUID = 2354181917311274337L;

	@Column(name = "NSS")
	private String nss;
	
	@Column(name = "NUM_TARJETA")
	private String numTarjeta;
	
	@Column(name = "TELEFONO")
	private String telefono;
	
	@Column(name = "DIRECCION")
	private String direccion;
	
	public Paciente() {}

	public Paciente(String nss, String numTarjeta, String telefono, String direccion) {
		this.nss = nss;
		this.numTarjeta = numTarjeta;
		this.telefono = telefono;
		this.direccion = direccion;
	}

	public String getNss() {
		return nss;
	}

	public void setNss(String nss) {
		this.nss = nss;
	}

	public String getNumTarjeta() {
		return numTarjeta;
	}

	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
}
