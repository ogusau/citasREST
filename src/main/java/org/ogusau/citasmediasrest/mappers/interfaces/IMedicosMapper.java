package org.ogusau.citasmediasrest.mappers.interfaces;

import java.util.List;

import org.ogusau.model.entities.Medico;

public interface IMedicosMapper {

	public void addMedico(Medico medico);
	public List<Medico> getMedicos();
	public Medico getMedico(int medicoId);
	public void updateMedico(Medico medico);
	public void deleteMedico(int medicoId);
}
