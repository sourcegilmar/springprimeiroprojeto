package com.gilmarborba.curso.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import com.gilmarborba.curso.entities.Order;
import com.gilmarborba.curso.entities.Product;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

// 4 Annotations do JPA
@Embeddable
public class OrderItemPK implements Serializable {

	// 1
	private static final long serialVersionUID = 1L;
	
	// 5 Annotations do JPA
	@ManyToOne
	@JoinColumn(name = "Order_Id")
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = "Product_Id")
	private Product product;
	
	// Não teremos os construturos
	
	// 2
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	// 3
	// HashCode e Equals usar os dois
	// Será uma chave estrangeira
	
	@Override
	public int hashCode() {
		return Objects.hash(order, product);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItemPK other = (OrderItemPK) obj;
		return Objects.equals(order, other.order) && Objects.equals(product, other.product);
	}
	
	
	
	
	
	
}
