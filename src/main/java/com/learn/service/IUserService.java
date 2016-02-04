package com.learn.service;

import java.util.List;

import com.learn.entity.User;

public interface IUserService {
	public User getUserById(int userId);
	
	public List<User> getAllUsers();
}
