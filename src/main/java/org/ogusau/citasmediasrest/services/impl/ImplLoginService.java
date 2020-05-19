package org.ogusau.citasmediasrest.services.impl;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.ejb.Stateless;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.ogusau.citasmediasrest.mappers.impl.ImplLoginMapper;
import org.ogusau.citasmediasrest.mappers.interfaces.ILoginMapper;
import org.ogusau.citasmediasrest.services.interfaces.ILoginService;
import org.ogusau.security.RestSecurityFilter;
import org.ogusau.security.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Stateless
public class ImplLoginService implements ILoginService{
	
	public static final String REDIR_PATH = "http://localhost:8080/citamedica"; 
	private ILoginMapper loginMapper = new ImplLoginMapper();
	
	@Context 
	private UriInfo uriInfo;		//???????

	@Override
	public Response authenticateUser(User user) {
		try {
            // Authenticate the user using the credentials provided
            if(loginMapper.login(user)) {
            	// Issue a token for the user
                String token = issueToken(user.getUsuario());
                
                // Return the token on the response
                return Response.ok().header(HttpHeaders.AUTHORIZATION, "Bearer " + token).build();
            }
            else{
            	// If authentication fails then redirect to main page again for a new try
            	return Response.temporaryRedirect(UriBuilder.fromUri(REDIR_PATH).build()).build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
	}
	
	private String issueToken(String login) {
    	Date now = new Date();
    	LocalDateTime ldt = LocalDateTime.ofInstant(now.toInstant(),
                ZoneId.systemDefault());

        String jwtToken = Jwts.builder()
                .setSubject(login)
                .setIssuer(uriInfo.getAbsolutePath().toString())
                .setIssuedAt(Date.from(ldt.now().atZone(ZoneId.systemDefault()).toInstant()))
                .setExpiration(Date.from(ldt.now().plusMinutes(60L).atZone(ZoneId.systemDefault()).toInstant()))
                .signWith(SignatureAlgorithm.HS512, RestSecurityFilter.KEY)
                .compact();
        return jwtToken;
    }

}
