package com.gilmarborba.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gilmarborba.curso.entities.OrderItem;
import com.gilmarborba.curso.repositories.OrderItemRepository;

// Necessário para registrar a classe como um 
// component ou Service e fazer a injeção

// @Component (Foi usado Service porque semanticamente
// é melhor
@ Service
public class OrderItemService {
	
	// É uma dependência do OrderItemService
	// O Autowired é a injeção
	
	@Autowired
	private OrderItemRepository repository;
	
	
	// Método da camada de serviço que repassa para o
	// controlador
	public List<OrderItem> findAll() {
		return repository.findAll();
	}
	
	public OrderItem findById(Long id) {
		Optional<OrderItem> obj = repository.findById(id);
		return obj.get();		
	}
	
	
	
	
}
