package org.ogusau.citasmediasrest.mappers.interfaces;

import java.util.List;

import org.ogusau.model.entities.Paciente;

public interface IPacientesMapper {
	public void addPaciente(Paciente paciente);
	public List<Paciente> getPacientes();
	public Paciente getPaciente(int pacienteId);
	public void updatePaciente(Paciente paciente);
	public void deletePaciente(int pacienteId);
}
