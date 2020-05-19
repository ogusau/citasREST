package org.ogusau.citasmediasrest.mappers.interfaces;

import java.util.List;

import org.ogusau.model.entities.Cita;
import org.ogusau.model.entities.Diagnostico;
import org.ogusau.model.mappedentities.CitasMapped;

public interface ICitasMapper {
	public List<Cita> getCitasUsuarioID(int idUsuario);
	public List<Cita> getAllCitas();
	public void createCita(Cita cita);
	public void deleteCita(int idCita);
	public void updateCita(Cita cita);
	public void addDiagnostico(int idCita, Diagnostico diagnostico);
}
