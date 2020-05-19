package org.ogusau.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Diagnostico")
public class Diagnostico implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 98106827837523269L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_DIAGNOSTICO")
	private int idDiagnostico;
	
	@Column(name = "VALORACION")
	private String valoracionEspecialista;
	
	@Column(name = "ENFERMEDAD")
	private String enfermedad;
	
	public Diagnostico() {}

	public Diagnostico(int idDiagnostico, String valoracionEspecialista, String enfermedad) {
		super();
		this.idDiagnostico = idDiagnostico;
		this.valoracionEspecialista = valoracionEspecialista;
		this.enfermedad = enfermedad;
	}

	public int getIdDiagnostico() {
		return idDiagnostico;
	}

	public void setIdDiagnostico(int idDiagnostico) {
		this.idDiagnostico = idDiagnostico;
	}

	public String getValoracionEspecialista() {
		return valoracionEspecialista;
	}

	public void setValoracionEspecialista(String valoracionEspecialista) {
		this.valoracionEspecialista = valoracionEspecialista;
	}

	public String getEnfermedad() {
		return enfermedad;
	}

	public void setEnfermedad(String enfermedad) {
		this.enfermedad = enfermedad;
	}
	
}
