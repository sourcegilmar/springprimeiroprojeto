package com.gilmarborba.curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CursoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursoApplication.class, args);		
		System.out.println("\n-----------------------");
		System.out.println("olá!");
		System.out.println("-----------------------\n");		
	}

}
