package com.gilmarborba.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gilmarborba.curso.entities.User;

// Essa annotation é opcional

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
