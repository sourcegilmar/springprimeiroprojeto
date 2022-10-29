package com.gilmarborba.curso.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gilmarborba.curso.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	// endpoint para acessar os usuários
	@GetMapping
	public ResponseEntity<User>findAll() {
		User u = new User(1L, "Maria", "maria@gmail.com", "60706070", "1234");
		//return ResponseEntity.ok().body(u);
		return ResponseEntity.ok().build();
	}
}
