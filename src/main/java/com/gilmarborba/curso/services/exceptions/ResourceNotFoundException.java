package com.gilmarborba.curso.services.exceptions;

// RuntimeException são exceções que o compilador não
// obriga tratar, são exceções de tempo de execução
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	// Construtor que recebe um object id
	// Passo o id do objeto que eu enviei mas não encontrei
	// para enviar a mensagem para o usuário
	public ResourceNotFoundException(Object id) {
		super("Resource Not Found. Id = "+id);
	}

}
