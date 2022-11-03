package com.gilmarborba.curso.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gilmarborba.curso.entities.Product;
import com.gilmarborba.curso.services.ProductService;

@RestController
@RequestMapping(value = "/users")
public class ProductResource {

	@Autowired
	private ProductService service;
	
	// endpoint para acessar os usuários
	@GetMapping
	public ResponseEntity<List<Product>>findAll() {
		// Product u = new Product(1L, "Maria", "maria@gmail.com", "60706070", "1234");
		//return ResponseEntity.ok().body(u);
		
		List<Product> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
}
