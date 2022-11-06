package com.gilmarborba.curso.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gilmarborba.curso.entities.User;
import com.gilmarborba.curso.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;
	
	// endpoint para acessar os usuários, esse endpoint
	// usa o método GET (@getMapping) do HTTP
	// localhost:8080/users
	@GetMapping
	public ResponseEntity<List<User>>findAll() {
		// User u = new User(1L, "Maria", "maria@gmail.com", "60706070", "1234");
		//return ResponseEntity.ok().body(u);
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	// endpoint para acessar os usuários, esse endpoint
	// usa o método GET (@getMapping) do HTTP
	// localhost:8080/users/id
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	// Agora, nesse endpoint, vamos usar o annotation @PostMapping
	// que usará o POST do HTTP. O @PostMapping vai fazer um pré processamento
	// na compilação do contrador definindo que esse métod vai receber
	// o POST do HTTP
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.ok().body(obj);
	}
	
	
}
