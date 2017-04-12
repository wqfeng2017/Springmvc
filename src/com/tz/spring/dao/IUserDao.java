package com.tz.spring.dao;

import java.util.List;

import com.tz.spring.entity.User;

public interface IUserDao {
	
	public void insert(User user);
	
	public User selectUserById(Long id);
	
	public User selectUserByName(String name);

	public List<User> selectUsers(String name);
	
	public void delete(User user);
	
	public void editor (User user);
}
