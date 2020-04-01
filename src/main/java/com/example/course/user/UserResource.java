package com.example.course.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	
	@GetMapping
	public ResponseEntity<User> findAll(){
		User user= new User(1L,"safs","sdgf","sef","sefts");
		return ResponseEntity.ok().body(user);
	}
	

}
