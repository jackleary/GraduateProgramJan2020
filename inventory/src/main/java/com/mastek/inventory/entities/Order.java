package com.mastek.inventory.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity // declares class as Entity, to be managed by JPA
@Table(name="JPA_Order") // declare table name associated with this class
public class Order {
	
	private int orderId;
	private double price;
	private int quantity;
	
	Customer currentCustomer;
	
	Set<Product> productList = new HashSet<>();
	
	@ManyToMany(cascade=CascadeType.ALL) // configure many to many associations for entities
	@JoinTable(
			name="JPA_ORDER_PRODUCTS", // provide join table name 
			joinColumns = {@JoinColumn(name="fk_orderId")}, // fk column for current class
			inverseJoinColumns = {@JoinColumn(name="fk_productId")} // fk column for collection
			)
	public Set<Product> getProductList() {
		return productList;
	}

	public void setProductList(Set<Product> productList) {
		this.productList = productList;
	}

	public Order() {
		// TODO Auto-generated constructor stub
	}
	
	@ManyToOne // One employee is associated with one of many departments
	@JoinColumn(name="fk_customer_no") // foreign key column to store the associate deptno
	public Customer getCurrentCustomer() {
		return currentCustomer;
	}



	public void setCurrentCustomer(Customer currentCustomer) {
		this.currentCustomer = currentCustomer;
	}


	@Id // marking property as primary key for the table
	@Column(name="orderId") // using column to provide default column name
	@GeneratedValue(strategy=GenerationType.AUTO) // Auto Numbering configurations as per DB
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + orderId;
		return result;
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
		if (orderId != other.orderId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", price=" + price + ", quantity=" + quantity + "]";
	}
	
	

}
