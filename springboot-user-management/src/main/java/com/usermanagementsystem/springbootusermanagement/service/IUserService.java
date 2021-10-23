package com.usermanagementsystem.springbootusermanagement.service;

import java.util.List;

import com.usermanagementsystem.springbootusermanagement.model.User;

public interface IUserService {

	List<User> getAllUsers();

	User getUser(long id);

	User saveUser(User user);

	void deleteUser(User user);

	List<User> getByKeyword(String keyword);
}
