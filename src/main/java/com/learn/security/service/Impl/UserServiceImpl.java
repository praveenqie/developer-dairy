package com.learn.security.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learn.security.dto.UsersData;
import com.learn.security.entity.User;
import com.learn.security.mapper.UsersDataMapper;
import com.learn.security.repository.UserRepository;
import com.learn.security.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private final UsersDataMapper dataMapper;
	
	public UserServiceImpl(UsersDataMapper usersDataMapper) {
		this.dataMapper = usersDataMapper;
	}
	
	@Override
	@Transactional
	public List<UsersData> getAllUsers() {
		return dataMapper.mapToListUsers(userRepository.findAll());
	}

	@Override
	@Transactional
	public UsersData getUserByEmail(String email) {
		return dataMapper.MapToUsers(userRepository.findByEmail(email).orElseThrow(() 
				-> new UsernameNotFoundException("User not found")));
	}

	@Override
	@Transactional
	public UsersData updateUser(User user) {
		User existingUser = userRepository.findById(user.getId())
				.orElseThrow(() -> new UsernameNotFoundException("User not found"));
		existingUser.setEmail(user.getEmail());
		return dataMapper.MapToUsers(userRepository.save(existingUser));
	}

	@Override
	public void deleteUser(int id) {
		User existingUser = userRepository.findById(id)
				.orElseThrow(() -> new UsernameNotFoundException("User not found"));

		userRepository.delete(existingUser);
	}
}
