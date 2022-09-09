package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseEntity<User> addUser(@RequestBody User user) {
		User c = null;
		try {
			c = this.userService.addUser(user);
			System.out.println(user);
			return ResponseEntity.of(Optional.of(c));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@RequestMapping(value = "/getuser", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getUser() {
		List<User> list = userService.getAllUser();
		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}

	@RequestMapping(value = "/user/{userId}", method = RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("userId") int userId) {
		try {
			this.userService.updateUser(user, userId);
			return ResponseEntity.ok().body(user);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@RequestMapping(value = "/user/{userId}", method = RequestMethod.DELETE)
	public ResponseEntity<User> deleteUser(@PathVariable("userId") int userId) {
		try {
			this.userService.deleteUser(userId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
