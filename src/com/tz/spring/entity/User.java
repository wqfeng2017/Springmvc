package com.tz.spring.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SPRING_User1")
public class User {
	private Long userId;
	private String username;
	private String password;
	private Date birthday;
	
	@Id
	@GeneratedValue
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(String username, String password, Date birthday) {
		super();
		this.username = username;
		this.password = password;
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [userId=").append(userId).append(", username=")
				.append(username).append(", password=").append(password)
				.append(", birthday=").append(birthday).append("]");
		return builder.toString();
	}
	
}
