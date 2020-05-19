package org.ogusau.model.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Citas")
public class Cita implements Serializable{

	private static final long serialVersionUID = -727329203436219577L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CITA")
	private int idCita;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "ID_CITA_DIAGNOSTICO")
	private Diagnostico diagnostico;
	
	@Column(name = "FECHA_HORA")
	private LocalDate fechaHora;
	
	@Column(name = "MOTIVO_CITA")
	private String motivoCita;
/*
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ID_CITA_PACIENTE", referencedColumnName="ID_PACIENTE_USUARIO")
    private Paciente paciente;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ID_CITA_MEDICO", referencedColumnName="ID_MEDICO_USUARIO")
    private Medico medico;*/
	
	@Column(name = "ID_CITA_PACIENTE")
	private int idPaciente;
	
	@Column(name = "ID_CITA_MEDICO")
	private int idMedico;
	
	
	public Cita() {}

	
	public Cita(int idCita, Diagnostico diagnostico, LocalDate fechaHora, String motivoCita, Paciente paciente,
			Medico medico, int idPaciente, int idMedico) {
		this.idCita = idCita;
		this.diagnostico = diagnostico;
		this.fechaHora = fechaHora;
		this.motivoCita = motivoCita;
	//	this.paciente = paciente;
	//	this.medico = medico;
		this.idPaciente = idPaciente;
		this.idMedico = idMedico;
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
/*
	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}
*/
	public int getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}

	public int getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
	}
	
}
