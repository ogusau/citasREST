package org.ogusau.citasmediasrest.resources.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.ogusau.citasmediasrest.mappers.impl.ImplPacientesMapper;
import org.ogusau.citasmediasrest.mappers.interfaces.IPacientesMapper;
import org.ogusau.citasmediasrest.resources.interfaces.IPacientesResource;
import org.ogusau.citasmediasrest.services.interfaces.IPacientesService;
import org.ogusau.model.entities.Paciente;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Stateless
@Path("/pacientes")
public class ImplPacientesResource implements IPacientesResource{
	
	private IPacientesMapper pacientesMapper = new ImplPacientesMapper();
	
	@EJB
	private IPacientesService iPacientesService;
	
	@GET
	@Path("/getPaciente/{pacienteId}")
    @Produces(MediaType.APPLICATION_JSON)
	@Override
	public Paciente getPaciente(@PathParam("pacienteId") int pacienteId) {
		return pacientesMapper.getPaciente(pacienteId);
		// return iPacientesService.getPaciente(pacienteId);
	}
	
	@GET
	@Path("/getAllPacientes")
    @Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<Paciente> getPacientes() {
		return pacientesMapper.getPacientes();
		//return iPacientesService.getPacientes();
	}
	
	@POST
	@Path("/addPaciente")
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public void addPaciente(Paciente paciente) {
		pacientesMapper.addPaciente(paciente);
		//iPacientesService.addPaciente(paciente);
		return;
	}
	
	@PUT
	@Path("/updatePaciente")
	@Override
	public void updatePaciente(Paciente paciente) {
		pacientesMapper.updatePaciente(paciente);
		//iPacientesService.updatePaciente(paciente);
		return;
	}
	
	@PATCH
	@Path("/deletePaciente/{pacienteId}")
	@Override
	public void deletePaciente(@PathParam("pacienteId") int pacienteId) {
		pacientesMapper.deletePaciente(pacienteId);
		//iPacientesService.deletePaciente(pacienteId);
		return;
	}
	
}
