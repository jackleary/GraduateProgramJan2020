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
@Table(name="JPA_Customer")
public class Customer {
	
	private int custId;
	private String name;
	private String email;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	Set<Order> customerList = new HashSet<>();
	
	@OneToMany(mappedBy="currentCustomer",cascade=CascadeType.ALL)
	public Set<Order> getCustomerList() {
		return customerList;
	}
	public void setCustomerList(Set<Order> customerList) {
		this.customerList = customerList;
	}
	
	@Id // marking property as primary key for the table
	@Column(name="customerId") // using column to provide default column name
	@GeneratedValue(strategy=GenerationType.AUTO) // Auto Numbering configurations as per DB or AUTO
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	
	@Column(name="customer_name",length=50,nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + custId;
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
		Customer other = (Customer) obj;
		if (custId != other.custId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", name=" + name + ", email=" + email + "]";
	}
	
	
}
