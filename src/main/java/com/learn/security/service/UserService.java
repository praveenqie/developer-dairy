package com.learn.security.service;

import java.util.List;

import com.learn.security.dto.UsersData;
import com.learn.security.entity.User;

public interface UserService {

	List<UsersData> getAllUsers();

	UsersData getUserByEmail(String email);

	UsersData updateUser(User user);

	void deleteUser(int id);

}
