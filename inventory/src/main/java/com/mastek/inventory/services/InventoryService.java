package com.mastek.inventory.services;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastek.inventory.dao.CategoryJPADAO;
import com.mastek.inventory.dao.CustomerJPADAO;
import com.mastek.inventory.dao.IngredientJPADAO;
import com.mastek.inventory.dao.OrderJPADAO;
import com.mastek.inventory.dao.ProductJPADAO;
import com.mastek.inventory.entities.Category;
import com.mastek.inventory.entities.Customer;
import com.mastek.inventory.entities.Ingredient;
import com.mastek.inventory.entities.Order;
import com.mastek.inventory.entities.Product;

@Component // marking class as bean to be created
@Scope("singleton") // singleton: One object used across test cases, prototype: one object per request
public class InventoryService {
	
	String exampleProperty;
	
	@Autowired
	CategoryJPADAO catDAO;
	
	@Autowired
	CustomerJPADAO custDAO;
	
	@Autowired
	IngredientJPADAO ingDAO;
	
	@Autowired
	OrderJPADAO ordDAO;
	
	@Autowired
	ProductJPADAO prodDAO;
	
	public InventoryService() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct // initialisation method of the class
	public void initializeService() {
		System.out.println("Inventory service initialized");
	}
	
	@PreDestroy // calls before shutting down the application
	public void terminateService() {
		System.out.println("Inventory service terminated");
	}
	
	public void exampleMethod() {
		System.out.println("Connect to "+getExampleProperty()+" for business data");
	}

	public String getExampleProperty() {
		return exampleProperty;
	}
	
	@Value("Spring example data source") // initialise property with the value 
	public void setExampleProperty(String exampleProperty) {
		System.out.println("Example property set: "+exampleProperty);
		this.exampleProperty = exampleProperty;
	}
	
	@Transactional
	public Order assignOrderToCustomer(int ordno, int custno) {
		Order ord = ordDAO.findById(ordno).get();
		Customer cust = custDAO.findById(custno).get();
		
		ord.setCurrentCustomer(cust);
		cust.getCustomerList().add(ord);
		
		ordDAO.save(ord);
		custDAO.save(cust);
		
		return ord;
	}
	
	@Transactional
	public Order assignOrderToProduct(int ordno, int prodno) {
		Order ord = ordDAO.findById(ordno).get();
		Product prod = prodDAO.findById(prodno).get();
		
		ord.getProductList().add(prod);
		ordDAO.save(ord);
		
		return ord;
		
	}

	@Transactional // complete method until value is returned
	public Product assignProductToIngredient(int prodId, int ingId) {
		Product prod = prodDAO.findById(prodId).get();
		Ingredient ing = ingDAO.findById(ingId).get();
		
		prod.getIngList().add(ing);
		prodDAO.save(prod);
		
		return prod;
	}

	@Transactional
	public Ingredient assignIngredientToCategory(int ingId, int catId) {
		Ingredient ing = ingDAO.findById(ingId).get();
		Category cat = catDAO.findById(catId).get();
		
		ing.setCurrentCategory(cat);
		cat.getIng().add(ing);
		
		return ing;
		
	}
	
}
