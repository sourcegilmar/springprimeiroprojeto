package com.gilmarborba.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gilmarborba.curso.entities.User;
import com.gilmarborba.curso.repositories.UserRepository;

// Necessário para registrar a classe como um 
// component ou Service e fazer a injeção

// @Component (Foi usado Service porque semanticamente
// é melhor
@ Service
public class UserService {
	
	// É uma dependência do UserService
	// O Autowired é a injeção
	
	@Autowired
	private UserRepository repository;
	
	
	// Método da camada de serviço que repassa para o
	// controlador
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();		
	}
	
	
	
	
}
