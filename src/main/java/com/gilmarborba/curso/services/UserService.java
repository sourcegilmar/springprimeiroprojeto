package com.gilmarborba.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gilmarborba.curso.entities.User;
import com.gilmarborba.curso.repositories.UserRepository;
import com.gilmarborba.curso.services.exceptions.DatabaseException;
import com.gilmarborba.curso.services.exceptions.ResourceNotFoundException;

// Necessário para registrar a classe como um 
// component ou Service e fazer a injeção

// @Component (Foi usado Service porque semanticamente
// é melhor
@Service
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
		// return obj.get(); // dava exceção 500 ...
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));

	}

	public User insert(User obj) {

		return repository.save(obj);
	}

	// O segundo catch levanta uma exceção da camada de serviço
	// o DatabaseException
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e ) {
			throw new DatabaseException(e.getMessage());
		}
	}

	// Entity é uma entidade Monitorada pelo JPA
	// ATENÇÃO: o MÉTODO getOne mudou de nome agora é
	// getReferenceBuId (para Spring 30)
	// O método updateData é criado automaticamente pelo
	// IDE no "tip" da linha onde está o updateData(entity,obj);
	public User update(Long Id, User obj) {
		
		try {
		// user entitty = repository.getOne(Id);
		User entity = repository.getReferenceById(Id);
		updateData(entity, obj);
		return repository.save(entity);
		} catch(RuntimeException e) {
			e.printStackTrace();			
			// Só para evitar erro por enquanto
			throw new ResourceNotFoundException(Id);
		}
		
	}

	// Só estamos deixando atualizar os campos "name",
	// "email" e "phone", o "id" e a "senha" não vou deixar
	// dessa forma, não coloco ele no corpo do método
	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}

}
