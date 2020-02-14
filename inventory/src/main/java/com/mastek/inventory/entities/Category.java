package com.mastek.inventory.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="JPA_Category")
public class Category {
	
	private int categoryId;
	private String name;
	
	Set<Ingredient> ing = new HashSet<>();
	
	@OneToMany(mappedBy="currentCategory",cascade=CascadeType.ALL)
	public Set<Ingredient> getIng() {
		return ing;
	}

	public void setIng(Set<Ingredient> ing) {
		this.ing = ing;
	}

	public Category() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column(name="categoryId") // using column to provide default column name
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

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
		result = prime * result + categoryId;
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
		Category other = (Category) obj;
		if (categoryId != other.categoryId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", name=" + name + "]";
	}
	
	

}
