package com.gilmarborba.curso.resource;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gilmarborba.curso.entities.Order;
import com.gilmarborba.curso.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
	@Autowired
	private OrderService service;

	// endpoint para acessar os usuários
	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		// Order u = new Order(1L, "Maria", "maria@gmail.com", "60706070", "1234");
		// return ResponseEntity.ok().body(u);

		List<Order> list = service.findAll();

		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id) {
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
