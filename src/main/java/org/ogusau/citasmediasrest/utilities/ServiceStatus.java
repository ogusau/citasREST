package org.ogusau.citasmediasrest.utilities;

import java.io.Serializable;

public class ServiceStatus implements Serializable{

	private static final long serialVersionUID = 4598275127802566023L;
	
	private String serverStatus;
	private String serverMessage;
	
	public ServiceStatus() {}
	
	public ServiceStatus(String serverStatus, String serverMessage) {
		this.serverStatus = serverStatus;
		this.serverMessage = serverMessage;
	}

	public String getServerStatus() {
		return serverStatus;
	}

	public void setServerStatus(String serverStatus) {
		this.serverStatus = serverStatus;
	}

	public String getServerMessage() {
		return serverMessage;
	}

	public void setServerMessage(String serverMessage) {
		this.serverMessage = serverMessage;
	}
	
	

}
