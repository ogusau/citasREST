package org.ogusau.citasmediasrest.services.interfaces;

import java.util.List;

import javax.ejb.Local;

import org.ogusau.model.entities.Cita;
import org.ogusau.model.entities.Diagnostico;
import org.ogusau.model.mappedentities.CitasMapped;

@Local
public interface ICitasService {
	public List<Cita> getCitasUsuarioID(int idUsuario);
	public List<Cita> getAllCitas();
	public void createCita(Cita cita);
	public void deleteCita(int idCita);
	public void updateCita(Cita cita);
	public void addDiagnostico(int idCita, Diagnostico diagnostico);
}
