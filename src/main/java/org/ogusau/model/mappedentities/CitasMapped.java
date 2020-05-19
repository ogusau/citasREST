package org.ogusau.model.mappedentities;

import java.time.LocalDate;

import org.ogusau.model.entities.Diagnostico;

public class CitasMapped {
	
	private int idCita;
	private Diagnostico diagnostico;
	private LocalDate fechaHora;
	private String motivoCita;
	private String nombrePaciente;
	private String nombreMedico;
	
	public CitasMapped() {}

	public CitasMapped(int idCita, Diagnostico diagnostico, LocalDate fechaHora, String motivoCita,
			String nombrePaciente, String nombreMedico) {
		this.idCita = idCita;
		this.diagnostico = diagnostico;
		this.fechaHora = fechaHora;
		this.motivoCita = motivoCita;
		this.nombrePaciente = nombrePaciente;
		this.nombreMedico = nombreMedico;
	}

	public int getIdCita() {
		return idCita;
	}

	public void setIdCita(int idCita) {
		this.idCita = idCita;
	}

	public Diagnostico getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(Diagnostico diagnostico) {
		this.diagnostico = diagnostico;
	}

	public LocalDate getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDate fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getMotivoCita() {
		return motivoCita;
	}

	public void setMotivoCita(String motivoCita) {
		this.motivoCita = motivoCita;
	}

	public String getNombrePaciente() {
		return nombrePaciente;
	}

	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}

	public String getNombreMedico() {
		return nombreMedico;
	}

	public void setNombreMedico(String nombreMedico) {
		this.nombreMedico = nombreMedico;
	}
		
}
