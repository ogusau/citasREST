package org.ogusau.citasmediasrest.services.interfaces;

import java.util.List;

import javax.ejb.Local;

import org.ogusau.model.entities.Paciente;

@Local
public interface IPacientesService {

	public Paciente getPaciente(int pacienteId);
	public List<Paciente> getPacientes();
	public void addPaciente(Paciente paciente);
	public void updatePaciente(Paciente paciente);
	public void deletePaciente(int pacienteId);
}
