package com.learn.security.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.learn.security.dto.UsersData;
import com.learn.security.entity.User;

@Component
public class UsersDataMapper {

	private final ModelMapper modelMapper;

    public UsersDataMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

	public List<UsersData> mapToListUsers(List<User> users) {
		return users.stream().map(this::MapToUsers).collect(Collectors.toList());

	}
	public UsersData MapToUsers(User user) {
		return modelMapper.map(user, UsersData.class);
	}
}
