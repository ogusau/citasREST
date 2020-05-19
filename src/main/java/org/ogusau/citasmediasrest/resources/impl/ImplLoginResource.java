package org.ogusau.citasmediasrest.resources.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;

import javax.ws.rs.core.Response;

import org.ogusau.citasmediasrest.resources.interfaces.ILoginResource;
import org.ogusau.citasmediasrest.services.interfaces.ILoginService;
import org.ogusau.security.User;

import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Stateless
@Path("/users")
@Transactional
public class ImplLoginResource implements ILoginResource{
	
	@EJB
	private ILoginService iLoginService;

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response authenticateUser() {		
    	User user = new User();
    	return iLoginService.authenticateUser(user);
    }
    
}
