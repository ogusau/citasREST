package org.ogusau.citasmediasrest.services.impl;

import java.util.List;

import javax.ejb.Stateless;

import org.ogusau.citasmediasrest.mappers.impl.ImplPacientesMapper;
import org.ogusau.citasmediasrest.mappers.interfaces.IPacientesMapper;
import org.ogusau.citasmediasrest.services.interfaces.IPacientesService;
import org.ogusau.model.entities.Paciente;

@Stateless
public class ImplPacientesService implements IPacientesService{

	private IPacientesMapper pacientesMapper = new ImplPacientesMapper();
	
	@Override
	public Paciente getPaciente(int pacienteId) {
		return pacientesMapper.getPaciente(pacienteId);
	}

	@Override
	public List<Paciente> getPacientes() {
		return pacientesMapper.getPacientes();
	}

	@Override
	public void addPaciente(Paciente paciente) {
		pacientesMapper.addPaciente(paciente);
		return;
	}

	@Override
	public void updatePaciente(Paciente paciente) {
		pacientesMapper.updatePaciente(paciente);
		return;
	}

	@Override
	public void deletePaciente(int pacienteId) {
		pacientesMapper.deletePaciente(pacienteId);
		return;
	}

}
