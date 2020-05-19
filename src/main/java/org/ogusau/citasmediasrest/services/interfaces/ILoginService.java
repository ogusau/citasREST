package org.ogusau.citasmediasrest.services.interfaces;

import javax.ejb.Local;
import javax.ws.rs.core.Response;

import org.ogusau.security.User;

@Local
public interface ILoginService {

	public Response authenticateUser(User user);
}
