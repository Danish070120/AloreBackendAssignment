package com.example.service;

import java.util.List;

import com.example.entity.User;

public interface UserService {

	User addUser(User user);

	List<User> getAllUser();

	void updateUser(User user, int userId);

	void deleteUser(int userId);

}
