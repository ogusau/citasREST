package org.ogusau.citasmediasrest.resources.impl;

import java.util.List;

import javax.ejb.Stateless;

import org.ogusau.citasmediasrest.mappers.impl.ImplCitasMapper;
import org.ogusau.citasmediasrest.mappers.interfaces.ICitasMapper;
import org.ogusau.citasmediasrest.resources.interfaces.ICitasResource;
import org.ogusau.model.entities.Cita;
import org.ogusau.model.entities.Diagnostico;
import org.ogusau.model.mappedentities.CitasMapped;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Stateless
@Path("/citas")
public class ImplCitasResource implements ICitasResource{
	
	private ICitasMapper citasMapper = new ImplCitasMapper();
	/*
	@Inject
	private ICitasService citasService;*/

	@GET
	@Path("/getCitasUsuarioID/{idUsuario}")
    @Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<Cita> getCitasUsuarioID(@PathParam("idUsuario") int idUsuario) {
		return citasMapper.getCitasUsuarioID(idUsuario);
		//return citasService.getCitasUsuarioID(idUsuario);
	}
	
	@GET
	@Path("/getAllCitas")
    @Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<Cita> getAllCitas() {
		return citasMapper.getAllCitas();
		//return citasMapper.getAllCitas();
	}
	
	@POST
	@Path("/createCita")
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public void createCita(Cita cita) {
		citasMapper.createCita(cita);
		//citasMapper.createCita(cita);
		return;
	}
	
	@DELETE
	@Path("/deleteCitas/{idCita}")
	@Override
	public void deleteCita(@PathParam("idCita") int idCita) {
		citasMapper.deleteCita(idCita);
		//citasMapper.deleteCita(idCita);
		return; 	
	}
	
	@PUT
	@Path("/updateCita")
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public void updateCita(Cita cita) {
		citasMapper.updateCita(cita);
		// citasMapper.updateCita(cita);
		return;
	}

	@PATCH
	@Path("/addDiagnostico/{idCita}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public void addDiagnostico(@PathParam("idCita") int idCita, Diagnostico diagnostico) {
		citasMapper.addDiagnostico(idCita, diagnostico);
		// citasMapper.addDiagnostico(idCita, diagnostico);
		return;
	}
}
