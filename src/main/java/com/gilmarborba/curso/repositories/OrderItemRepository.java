package com.gilmarborba.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gilmarborba.curso.entities.OrderItem;

// Essa annotation é opcional

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
