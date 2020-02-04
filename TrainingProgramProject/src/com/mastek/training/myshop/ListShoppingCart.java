package com.mastek.training.myshop;

import java.util.LinkedList;
import java.util.List;

public class ListShoppingCart implements ShoppingCart<Item> {

	List<Item> items;
	
	public ListShoppingCart() {
		items = new LinkedList<Item>();
	}
	
	@Override
	public int addItem(Item i) {
		// TODO Auto-generated method stub
		items.add(i);
		return items.size();
	}

	@Override
	public int removeItem(Item i) {
		// TODO Auto-generated method stub
		System.out.println("Index of item to be removed "+items.indexOf(i));
		items.remove(i);
		return items.size();
	}

	@Override
	public void printItems() {
		// TODO Auto-generated method stub
		System.out.println("Items in Cart");
		for (Item item : items) {
			System.out.println(item);
		}
	}

	@Override
	public double getTotalPrice(double taxPercentage, double discountPercentage) {
		// TODO Auto-generated method stub
		return 0;
	}

}
