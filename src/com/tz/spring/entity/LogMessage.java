package com.tz.spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SPRING_LOG")

public class LogMessage {
	private Long logId;
	private String message;
	
	public LogMessage() {
		// TODO Auto-generated constructor stub
	}

	
	
	public LogMessage(Long logId, String message) {
		super();
		this.logId = logId;
		this.message = message;
	}


	public LogMessage(String message) {
		super();
		this.message = message;
	}



	@Id
	@GeneratedValue
	public Long getLogId() {
		return logId;
	}

	public void setLogId(Long logId) {
		this.logId = logId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
