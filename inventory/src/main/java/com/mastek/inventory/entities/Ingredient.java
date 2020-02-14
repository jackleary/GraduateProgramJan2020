package com.mastek.inventory.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="JPA_Ingredient")
public class Ingredient {
	
	private int ingredientId;
	private String name;
	private double unitPrice;
	
	Set<Product> prodList = new HashSet<>();
	
	@ManyToMany(mappedBy="ingList")
	public Set<Product> getProdList() {
		return prodList;
	}

	public void setProdList(Set<Product> prodList) {
		this.prodList = prodList;
	}

	Category currentCategory;
	
	@ManyToOne
	@JoinColumn(name="fk_categoryId")
	public Category getCurrentCategory() {
		return currentCategory;
	}

	public void setCurrentCategory(Category currentCategory) {
		this.currentCategory = currentCategory;
	}

	public Ingredient() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column(name="ingredientId") // using column to provide default column name
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getIngredientId() {
		return ingredientId;
	}

	public void setIngredientId(int ingredientId) {
		this.ingredientId = ingredientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ingredientId;
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
		Ingredient other = (Ingredient) obj;
		if (ingredientId != other.ingredientId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ingredient [ingredientId=" + ingredientId + ", name=" + name + ", unitPrice=" + unitPrice + "]";
	}
	
	
	
}
