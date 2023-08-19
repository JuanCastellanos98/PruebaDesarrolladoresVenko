package com.venko.prueba.ConfigSecurity;

import lombok.Data;

@Data
public class AuthCredentials {
	private String cc;
	private String password;
	public String getCc() {
		return cc;
	}
	public void setCc(String cc) {
		this.cc = cc;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
}
