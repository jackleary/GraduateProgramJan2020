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
import javax.persistence.Table;

@Entity
@Table(name="JPA_Product")
public class Product {
	
	private int productId;
	private double unitPrice;
	private String name;
	
	Set<Order> orderList = new HashSet<>();
	
	@ManyToMany(mappedBy="productList")
	public Set<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(Set<Order> orderList) {
		this.orderList = orderList;
	}
	Set<Ingredient> ingList = new HashSet<>();

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
			name="JPA_ING_ASSIGNMENTS",
			joinColumns= {@JoinColumn(name="fk_productId")},
			inverseJoinColumns= {@JoinColumn(name="fk_ingredientId")}
			)
	public Set<Ingredient> getIngList() {
		return ingList;
	}

	public void setIngList(Set<Ingredient> ingList) {
		this.ingList = ingList;
	}

	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	@Id // marking property as primary key for the table
	@Column(name="productId") // using column to provide default column name
	@GeneratedValue(strategy=GenerationType.AUTO) // Auto Numbering configurations as per DB OR AUTO
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	@Column(name="product_name",length=50,nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + productId;
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
		Product other = (Product) obj;
		if (productId != other.productId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", unitPrice=" + unitPrice + ", name=" + name + "]";
	}
	
	
	
}
