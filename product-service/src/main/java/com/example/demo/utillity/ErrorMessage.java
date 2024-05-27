package com.example.demo.utillity;

import java.time.LocalDateTime;

public class ErrorMessage {
	
	
	private String description;
	private String message;
	private LocalDateTime dateTime;
	
	public ErrorMessage() {
		super();
	}
	public ErrorMessage(String description, String message, LocalDateTime dateTime) {
		super();
		this.description = description;
		this.message = message;
		this.dateTime = dateTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	
	
	

}
