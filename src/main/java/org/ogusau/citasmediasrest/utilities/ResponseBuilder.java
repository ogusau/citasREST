package org.ogusau.citasmediasrest.utilities;

import com.google.gson.Gson;

public class ResponseBuilder {
	
	private static Gson gson = new Gson(); 
	
	public static String buildReponse(ServiceResponse serviceResponse) {
		return gson.toJson(serviceResponse);
	}
	
}
