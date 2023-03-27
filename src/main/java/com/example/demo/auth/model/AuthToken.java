package com.example.demo.auth.model;

public class AuthToken {
	
	private String token;
	
	public AuthToken(String token) {
		this.setToken(token);
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
