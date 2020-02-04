package com.mastek.training.myshop;

import java.util.HashMap;
import java.util.Map;

public class MapShoppingCart implements ShoppingCart<Item> {

	Map<Integer, Item> items;
	
	public MapShoppingCart() {
		// items = new HashMap<>(); // maintain random entries for the collection
		items = new HashMap<>(); // treeMap sorts all entries using the keys:: itemId
	}
	
	@Override
	public int addItem(Item i) {
		// TODO Auto-generated method stub
		items.put(i.getItemId(), i); // map.put(key,value)
		return items.size();
	}

	@Override
	public int removeItem(Item i) {
		// TODO Auto-generated method stub
		items.remove(i.getItemId()); // map.remove(key)
		return items.size();
	}

	@Override
	public void printItems() {
		// TODO Auto-generated method stub
		System.out.println("Items in Cart");
		for (Integer itemId: items.keySet()) { // get all keys from Map
			Item i = items.get(itemId); // gets the value from the map using the key
			System.out.println(i);
		}
	}

	@Override
	public double getTotalPrice(double taxPercentage, double discountPercentage) {
		// TODO Auto-generated method stub
		return 0;
	}

}
