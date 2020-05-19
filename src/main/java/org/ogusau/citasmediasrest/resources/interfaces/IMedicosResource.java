package org.ogusau.citasmediasrest.resources.interfaces;

import java.util.List;

import org.ogusau.model.entities.Medico;

public interface IMedicosResource {
	
	public void addMedico(Medico medico);
	public List<Medico> getMedicos();
	public Medico getMedico(int id);
	public void updateMedico(Medico medico);
	public void deleteMedico(int medicoId);
}
