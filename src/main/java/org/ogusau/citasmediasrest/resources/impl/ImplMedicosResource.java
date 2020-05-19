package org.ogusau.citasmediasrest.resources.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.ogusau.citasmediasrest.mappers.impl.ImplMedicosMapper;
import org.ogusau.citasmediasrest.mappers.interfaces.IMedicosMapper;
import org.ogusau.citasmediasrest.resources.interfaces.IMedicosResource;
import org.ogusau.citasmediasrest.services.interfaces.IMedicosService;
import org.ogusau.model.entities.Medico;

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
@Path("/medicos")
public class ImplMedicosResource implements IMedicosResource{
	
	private IMedicosMapper mapperMapper = new ImplMedicosMapper();
	
	@EJB
	private IMedicosService iMedicosService;

	@GET
	@Path("/getAllMedicos")
    @Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<Medico> getMedicos() {
		return mapperMapper.getMedicos();
		// return iMedicosService.getMedicos();
	}

	@GET
	@Path("getMedico/{medicoId}")
    @Produces(MediaType.APPLICATION_JSON)
	@Override
	public Medico getMedico(@PathParam("medicoId") int medicoId) {
		return mapperMapper.getMedico(medicoId);
		//return iMedicosService.getMedico(medicoId);
	}
	
	@POST
	@Path("/addMedico")
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public void addMedico(Medico medico) {
		mapperMapper.addMedico(medico);
		//return iMedicosService.addMedico(medico);
	}
	
	@PUT
	@Path("/updateMedico")
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public void updateMedico(Medico medico) {
		mapperMapper.updateMedico(medico);
		return;
		//return iMedicosService.updateMedico(medico);
	}

	@PATCH
	@Path("/deleteMedico/{medicoId}")
	@Override
	public void deleteMedico(@PathParam("medicoId") int medicoId) {
		mapperMapper.deleteMedico(medicoId);
		return;
		// return iMedicosService.deleteMedico(medicoId);
	}

}
