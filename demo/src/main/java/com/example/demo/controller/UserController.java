package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;

@RestController
public class UserController {

	private List<User> lstUsers = new ArrayList<User>();

	@GetMapping("/hello")
	public ResponseEntity<String> hello() {
		return new ResponseEntity<>("Hello World!", HttpStatus.OK);
	}

	@PostMapping("/user")
	public User create(@RequestBody User user) {
		lstUsers.add(user);
		return user;

	}
	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable(value = "id") int id) {
		for (int i = 0; i < lstUsers.size(); i++) {
			if (lstUsers.get(i).getId() == id) {
				return lstUsers.get(i);
			}
		}
		return null;

	}

	@GetMapping("/listUsers")
	public List<User> getAll() {
		return lstUsers;
	}

	@DeleteMapping("/user")
	public void delete(@RequestParam(name = "id") int id) {
		for (int i = 0; i < lstUsers.size(); i++) {
			if (lstUsers.get(i).getId() == id) {
				lstUsers.remove(i);
				break;
			}
		}
	}

//	// Postman http://localhost:8080/demo/user/1
//		@DeleteMapping("/user/{id}")
//		public void delete(@PathVariable(value = "id") int id) {
//			for (int i = 0; i < users.size(); i++) {
//				if(users.get(i).getId() == id) {
//					users.remove(i);
//					break;
//				}
//			}
//		}

	@PutMapping("/update")
	public void update(@RequestBody User user) {
		for (int i = 0; i < lstUsers.size(); i++) {
			if (lstUsers.get(i).getId() == user.getId()) {
				lstUsers.set(i, user);
				break;
			}
		}
	}

}
