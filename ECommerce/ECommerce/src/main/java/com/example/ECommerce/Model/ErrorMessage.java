package com.example.ECommerce.Model;

import java.sql.Timestamp;

public class ErrorMessage {
	
	Timestamp time;
	String Errormessage;
	String description;
	
	
	public ErrorMessage() {
		super();
	}
	public ErrorMessage(Timestamp time, String errormessage, String description) {
		super();
		this.time = time;
		Errormessage = errormessage;
		this.description = description;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public String getErrormessage() {
		return Errormessage;
	}
	public void setErrormessage(String errormessage) {
		Errormessage = errormessage;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
