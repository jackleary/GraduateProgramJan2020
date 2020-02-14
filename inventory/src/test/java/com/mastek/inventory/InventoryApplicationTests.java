package com.mastek.inventory;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
import com.mastek.inventory.services.InventoryService;

@SpringBootTest
class InventoryApplicationTests {
	
	@Autowired
	IngredientJPADAO ingDAO;
	
	@Autowired
	CustomerJPADAO cusDAO;
	
	@Autowired
	CategoryJPADAO catDAO;
	
	@Autowired
	OrderJPADAO ordDAO;
	
	@Autowired
	ProductJPADAO prodDAO;
	
	@Autowired
	InventoryService invSvc;

	@Test
	void testIngredientDAOAdd() {
		Ingredient ing = new Ingredient();
		//ing.setIngredientId(1);
		ing.setName("Apple");
		ing.setUnitPrice(2.00);
		
		ing = ingDAO.save(ing);
		
		System.out.println(ing);
		assertNotNull(ing,"Ingredient Not Added");
				
	}
	
	@Test
	void testListIngredients() {
		Iterable<Ingredient> ing = ingDAO.findAll();
		assertNotNull(ing,"Ing Not Found");
		for (Ingredient ingredient : ing) {
			System.out.println(ingredient);
		}
	}
	
	@Test
	void testUpdateIngredients(){
		Ingredient ing = ingDAO.findById(2).get();
		assertNotNull(ing, "Ing Not Found");
		
		ing.setUnitPrice(5.00);
		
		ing = ingDAO.save(ing);
		System.out.println("Updated ingredient: "+ing);
		
	}
	
	@Test
	void testCustomerDAOAdd() {
		Customer cus = new Customer();
		//cus.setCustId(1);
		cus.setEmail("john@gmail.com");
		cus.setName("Jack");
		
		cus = cusDAO.save(cus);
		
		System.out.println(cus);
		assertNotNull(cus,"Cus Not Added");
	}
	
	//@Test
	void testUpdateCustomer() {
		Customer cus = cusDAO.findById(4).get();
		assertNotNull(cus, "Cus Not Found");
		
		cus.setName("Google");
		cus.setEmail("google@gmail.com");
		
		cus = cusDAO.save(cus);
		System.out.println("Updated customer: "+cus);
	}
	
	@Test
	void testListCustomers() {
		Iterable<Customer> cus = cusDAO.findAll();
		assertNotNull(cus, "Cus Not Found");
		for (Customer customer : cus) {
			System.out.println(customer);
		}
	}
	
	@Test
	void testCategoryDAOAdd() {
		Category cat = new Category();
		//cat.setCategoryId(1);
		cat.setName("hi");
		
		cat = catDAO.save(cat);
		
		System.out.println(cat);
		assertNotNull(cat,"Cat Not Added");
	}
	
	@Test
	void testListCategorys() {
		Iterable<Category> cat = catDAO.findAll();
		assertNotNull(cat, "Cat Not Found");
		for (Category category : cat) {
			System.out.println(category);
		}
	}
	
	@Test
	void testOrderDAOAdd() {
		Order ord = new Order();
		//ord.setOrderId(1);
		ord.setPrice(5.00);
		ord.setQuantity(2);
		
		ord = ordDAO.save(ord);
		
		System.out.println(ord);
		assertNotNull(ord,"Ord Not Added");
	}
	
	@Test
	void testListOrders() {
		Iterable<Order> ord = ordDAO.findAll();
		assertNotNull(ord, "Ord Not Found");
		for (Order order : ord) {
			System.out.println(order);
		}
	}
	
	@Test
	void testProductDAOAdd() {
		Product prod = new Product();
		//prod.setProductId(1);
		prod.setName("Example");
		prod.setUnitPrice(2.00);
		
		prod = prodDAO.save(prod);
		
		System.out.println(prod);
		assertNotNull(prod,"Prod Not Added");
	}
	
	@Test
	void testListProducts() {
		Iterable<Product> prod = prodDAO.findAll();
		assertNotNull(prod,"Prod Not Found");
		for (Product product : prod) {
			System.out.println(product);
		}
	}
	
	@Test
	void testAssignOrderToCustomer() {
		Order ord = invSvc.assignOrderToCustomer(10, 9);
		assertNotNull(ord.getCurrentCustomer(),"IDs Not Assigned");
	}

	@Test
	void testAssignOrderToProduct() {
		Order ord = invSvc.assignOrderToProduct(5, 1);
		assertTrue(ord.getProductList().size()>0,"IDs Not Assigned");
	}
	
	@Test
	void testAssignProductsToIngredients() {
		Product prod = invSvc.assignProductToIngredient(1,2);
		assertTrue(prod.getIngList().size()>0,"IDs Not Assigned");
	}
	
	@Test
	void testAssignIngredientToCategory() {
		Ingredient ing = invSvc.assignIngredientToCategory(2,3);
		assertNotNull(ing.getCurrentCategory(),"IDs Not Assigned");
	}
	
}
