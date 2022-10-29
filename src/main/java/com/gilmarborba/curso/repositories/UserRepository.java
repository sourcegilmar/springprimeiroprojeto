package com.gilmarborba.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gilmarborba.curso.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
