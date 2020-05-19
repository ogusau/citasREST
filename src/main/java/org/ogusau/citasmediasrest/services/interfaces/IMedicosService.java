package org.ogusau.citasmediasrest.services.interfaces;

import java.util.List;

import javax.ejb.Local;

import org.ogusau.model.entities.Medico;

@Local
public interface IMedicosService {
	public List<Medico> getMedicos();
	public Medico getMedico(int medicoId);
	public void addMedico(Medico medico);
	public void updateMedico(Medico medico);
	public void deleteMedico(int medicoId);
}
