package org.ogusau.citasmediasrest.services.impl;

import java.util.List;

import javax.ejb.Stateless;

import org.ogusau.citasmediasrest.mappers.impl.ImplMedicosMapper;
import org.ogusau.citasmediasrest.mappers.interfaces.IMedicosMapper;
import org.ogusau.citasmediasrest.services.interfaces.IMedicosService;
import org.ogusau.model.entities.Medico;

@Stateless
public class ImplMedicosService implements IMedicosService{
	
	private IMedicosMapper mapperMapper = new ImplMedicosMapper();

	@Override
	public List<Medico> getMedicos() {
		return mapperMapper.getMedicos();
	}

	@Override
	public Medico getMedico(int medicoId) {
		return mapperMapper.getMedico(medicoId);
	}

	@Override
	public void addMedico(Medico medico) {
		mapperMapper.addMedico(medico);
	}

	@Override
	public void updateMedico(Medico medico) {
		mapperMapper.updateMedico(medico);
		return;
	}

	@Override
	public void deleteMedico(int medicoId) {
		mapperMapper.deleteMedico(medicoId);
		return;
	}

}
