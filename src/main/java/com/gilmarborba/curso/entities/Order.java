package com.gilmarborba.curso.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gilmarborba.curso.entities.enuns.OrderStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_Order")
public class Order implements Serializable  {


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",timezone = "GMT")
	private Instant moment;
	
	// Após a mudança da classe Enum, vamos alterar o tipo da
	// variável orderStatus, de OrderStatus para Integer
	// private OrderStatus orderstatus; Internamente no programa
	// tratará como inteiro mas no banco continuará o literal 
	private Integer orderStatus;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "client_id")
	private User client;
		
	public Order() {
		
	}

	public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {
		super();
		this.id = id;
		this.moment = moment;
		//this.orderStatus = orderStatus;
		setOrderStatus(orderStatus);
		this.client = client;
	}



	public Order(Long id, Instant moment) {		
		this.id = id;
		this.moment = moment;		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	public OrderStatus getOrderstatus() {
		// return orderstatus;
		return OrderStatus.valueOf(orderStatus);
		// pega o inteiro externo da classe e converte para
		// OrderStatus
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus.getCode();
		
		// Aqui é o contrário: pega o tipo OrderStatus e 
		// converte ele para inteiro
		
		// O teste é feito porque vai que o programador passa
		// um nulo aqui!
		if (orderStatus != null) {
			this.orderStatus = orderStatus.getCode();
		}
		
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}
		
}
