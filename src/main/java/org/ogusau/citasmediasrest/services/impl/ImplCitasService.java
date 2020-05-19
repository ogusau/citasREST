package org.ogusau.citasmediasrest.services.impl;

import java.util.List;

import javax.ejb.Stateless;

import org.ogusau.citasmediasrest.mappers.impl.ImplCitasMapper;
import org.ogusau.citasmediasrest.mappers.interfaces.ICitasMapper;
import org.ogusau.citasmediasrest.services.interfaces.ICitasService;
import org.ogusau.model.entities.Cita;
import org.ogusau.model.entities.Diagnostico;
import org.ogusau.model.mappedentities.CitasMapped;

@Stateless
public class ImplCitasService implements ICitasService{

	private ICitasMapper citasMapper;
	
	public ImplCitasService() {
		citasMapper = new ImplCitasMapper();
	}
	
	@Override
	public List<Cita> getCitasUsuarioID(int idUsuario) {
		return citasMapper.getCitasUsuarioID(idUsuario);
	}

	@Override
	public List<Cita> getAllCitas() {
		return citasMapper.getAllCitas();
	}

	@Override
	public void createCita(Cita cita) {
		citasMapper.createCita(cita);
		return;
	}

	@Override
	public void deleteCita(int idCita) {
		citasMapper.deleteCita(idCita);
		return;
	}

	@Override
	public void updateCita(Cita cita) {
		citasMapper.updateCita(cita);
		return;
	}

	@Override
	public void addDiagnostico(int idCita, Diagnostico diagnostico) {
		citasMapper.addDiagnostico(idCita, diagnostico);
		return;
	}

}
