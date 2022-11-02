package com.gilmarborba.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gilmarborba.curso.entities.Category;
import com.gilmarborba.curso.repositories.CategoryRepository;

// Necessário para registrar a classe como um 
// component ou Service e fazer a injeção

// @Component (Foi usado Service porque semanticamente
// é melhor
@ Service
public class CategoryService {
	
	// É uma dependência do CategoryService
	// O Autowired é a injeção
	
	@Autowired
	private CategoryRepository repository;
	
	
	// Método da camada de serviço que repassa para o
	// controlador
	public List<Category> findAll() {
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();		
	}	
	
}
