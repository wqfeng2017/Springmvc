package com.tz.spring.service;

import java.util.List;

import com.tz.spring.entity.User;

public interface IUserService {
	
	public void save(User user);
	
	public User queryUserById(Long id);
	
	public User queryUserByName(String name);

	public List<User> queryUsers(String name);
	
	public void remove(User user);
	
	public void modify(User user);
}
