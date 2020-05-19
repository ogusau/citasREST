package org.ogusau.citasmediasrest.resources.interfaces;

import java.util.List;

import org.ogusau.model.entities.Paciente;

public interface IPacientesResource {

	public void addPaciente(Paciente paciente);
	public List<Paciente> getPacientes();
	public Paciente getPaciente(int id);
	public void updatePaciente(Paciente paciente);
	public void deletePaciente(int pacienteId);
}
