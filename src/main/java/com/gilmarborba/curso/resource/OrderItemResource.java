package com.gilmarborba.curso.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gilmarborba.curso.entities.OrderItem;
import com.gilmarborba.curso.services.OrderItemService;

@RestController
@RequestMapping(value = "/orderitems")
public class OrderItemResource {

	@Autowired
	private OrderItemService service;
	
	// endpoint para acessar os usuários
	@GetMapping
	public ResponseEntity<List<OrderItem>>findAll() {
		// OrderItem u = new OrderItem(1L, "Maria", "maria@gmail.com", "60706070", "1234");
		//return ResponseEntity.ok().body(u);
		
		List<OrderItem> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<OrderItem> findById(@PathVariable Long id) {
		OrderItem obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
}
