package org.ogusau.citasmediasrest.utilities;

import java.io.Serializable;

public class ServiceResponse implements Serializable{

	private static final long serialVersionUID = -7444191081859886145L;
	
	private Object responseValue;
	private ServiceStatus serviceStatus;
	
	public ServiceResponse() {}
	
	public ServiceResponse(Object responseValue, ServiceStatus serviceStatus) {
		this.responseValue = responseValue;
		this.serviceStatus = serviceStatus;
	}
	public Object getResposeValue() {
		return responseValue;
	}
	public void setResposeValue(Object resposeValue) {
		this.responseValue = resposeValue;
	}
	public ServiceStatus getServiceStatus() {
		return serviceStatus;
	}
	public void setServiceStatus(ServiceStatus serviceStatus) {
		this.serviceStatus = serviceStatus;
	}
	
	
}
