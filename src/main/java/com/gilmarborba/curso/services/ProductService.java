package com.gilmarborba.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gilmarborba.curso.entities.Product;
import com.gilmarborba.curso.repositories.ProductRepository;

// Necessário para registrar a classe como um 
// component ou Service e fazer a injeção

// @Component (Foi usado Service porque semanticamente
// é melhor
@ Service
public class ProductService {
	
	// É uma dependência do ProductService
	// O Autowired é a injeção
	
	@Autowired
	private ProductRepository repository;
		
	// Método da camada de serviço que repassa para o
	// controlador
	public List<Product> findAll() {
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();		
	}
}
