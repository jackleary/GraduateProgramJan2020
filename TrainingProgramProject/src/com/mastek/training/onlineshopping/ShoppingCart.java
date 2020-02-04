package com.mastek.training.onlineshopping;

import com.mastek.training.onlineshopping.ItemDetails;

//Create a class structure for online shopping cart, to add Items, remove, view items and print grand total, 
//apply tax [20%] , apply Giftcode{['Black']:50% off}
//Item details: item name , quantity and unit price with max of 10 items per order

public class ShoppingCart extends ItemDetails{
	
	private double cost;
	
	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public void addPrice(ShoppingCart newItem) {
		this.cost = super.getItemCost() + newItem.getItemCost();
		System.out.println("Total Cost: "+getCost());
	}
	
	public void shoppingCart() {
		
		String sc[]= new String[] {"Apple","Pear","Lolipop"};
		
	}
	
}
