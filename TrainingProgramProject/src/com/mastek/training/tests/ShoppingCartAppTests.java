package com.mastek.training.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mastek.training.myshop.Item;
import com.mastek.training.myshop.ListShoppingCart;
import com.mastek.training.myshop.MapShoppingCart;
import com.mastek.training.myshop.SetShoppingCart;
import com.mastek.training.myshop.ShoppingCart;

class ShoppingCartAppTests {
	
	ShoppingCart<Item> sc1;
	
	@BeforeEach
	void setUp() throws Exception {
		System.out.println("<============Before Test============>");
		// sc1 = new ListShoppingCart(); // List Example
		// sc1 = new SetShoppingCart(); // Set Example
		sc1 = new MapShoppingCart(); // Map Example
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("<============After Test============>");
		sc1 = null;
	}

	@Test
	void testShoppingCartAddItem() {
		int size = sc1.addItem(new Item(1,"Name",233.0,1));
		assertEquals(1,size,"Item Added");
	}
	
	@Test
	void testShoppingCartPrintItems() {
		sc1.addItem(new Item(4,"Item 4",3233.0,1));
		sc1.addItem(new Item(2,"Item 2",1233.0,1));
		sc1.addItem(new Item(3,"Item 3",2233.0,1));
		sc1.addItem(new Item(1,"Item 1",233.0,1));
		sc1.addItem(new Item(2,"Item 2",1233.0,1));
		sc1.addItem(new Item(3,"Item 3",2233.0,1));
		sc1.addItem(new Item(3,"Item 3",2233.0,1));
		
		sc1.printItems();
	}
	
	@Test
	void testShoppingCartRemoveItems() {
		sc1.addItem(new Item(1,"Item 1",233.0,1));
		sc1.addItem(new Item(2,"Item 2",1233.0,1));
		sc1.addItem(new Item(3,"Item 3",2233.0,1));
		sc1.printItems();
		
		int size = sc1.removeItem(new Item(2));
		sc1.printItems();
		
		assertEquals(2, size,"Item Removed");
		
		
	}


}
