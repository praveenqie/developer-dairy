package com.learn.security.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.security.dto.UsersData;
import com.learn.security.entity.User;
import com.learn.security.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	@PreAuthorize("hasAuthority('admin:read')")
	public List<UsersData> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/{email}")
	public ResponseEntity<UsersData> getUserByEmail(@PathVariable String email) {
		UsersData user =  userService.getUserByEmail(email);
		 if (Objects.nonNull(user)) {
	            return ResponseEntity.ok(user);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	}

	@PutMapping
	public ResponseEntity<UsersData> updateUser(@RequestBody User user) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.updateUser(user));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable int id) {
		userService.deleteUser(id);
		return ResponseEntity.noContent().build();
	}
}
