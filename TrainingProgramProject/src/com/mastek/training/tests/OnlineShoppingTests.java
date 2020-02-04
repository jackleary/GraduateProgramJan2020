package com.mastek.training.tests;

import org.junit.jupiter.api.Test;

import com.mastek.training.onlineshopping.ItemDetails;

class OnlineShoppingTests {

	@Test
	void testCreateAndPrintShopObject() {
		ItemDetails shop = new ItemDetails();
		shop.setItemName("Apple");
		shop.setQuantity(9);
		shop.setItemCost(5.00);
		
		System.out.println("Item Name: "+shop.getItemName()+", Quantity: "+shop.getQuantity()+", Price: "+shop.getItemCost());
		// assertEquals(0,shop.getQuantity(11),"Invalid input");
	}
	
	

}
