package com.usermanagementsystem.springbootusermanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usermanagementsystem.springbootusermanagement.exception.UserNotFoundException;
import com.usermanagementsystem.springbootusermanagement.model.User;
import com.usermanagementsystem.springbootusermanagement.repository.UserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(long id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("User with id=" + id + "not found."));
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(User user) {
		userRepository.delete(user);
	}

	@Override
	public List<User> getByKeyword(String keyword) {
		return userRepository.findByKeyword(keyword);
	}
}
