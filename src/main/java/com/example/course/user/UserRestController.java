package com.example.course.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@RequestMapping(value="/users")
public class UserRestController {
	
	private UserService userService;

	public UserRestController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public ResponseEntity<List<User>> findAll(){
	List<User> users = userService.findAll();
		return ResponseEntity.ok().body(users);
	}

	@GetMapping(value="/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User user = userService.findById(id);
		return ResponseEntity.ok().body(user);
	}

	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User user){
		userService.insert(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).body(user);
	}

	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		userService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value="/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user){
		user = userService.update(id,user);
		return ResponseEntity.ok().body(user);
	}
	

}
