package com.gilmarborba.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gilmarborba.curso.entities.Order;
import com.gilmarborba.curso.repositories.OrderRepository;

// Necessário para registrar a classe como um 
// component ou Service e fazer a injeção

// @Component (Foi usado Service porque semanticamente
// é melhor
@ Service
public class OrderService {
	
	// É uma dependência do OrderService
	// O Autowired é a injeção
	
	@Autowired
	private OrderRepository repository;
	
	
	// Método da camada de serviço que repassa para o
	// controlador
	public List<Order> findAll() {
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();		
	}
	
	
	
	
}
