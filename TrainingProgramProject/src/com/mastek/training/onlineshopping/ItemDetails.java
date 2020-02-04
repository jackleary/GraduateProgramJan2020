package com.mastek.training.onlineshopping;


// Create a class structure for online shopping cart, to add Items, remove, view items and print grand total, 
// apply tax [20%] , apply Giftcode{['Black']:50% off}
// Item details: item name , quantity and unit price with max of 10 items per order


public class ItemDetails {
	
	private int itemId;
	private String itemName;
	private int quantity;
	private double itemCost;
	
	public String getItemName() {
		return itemName;
	}
	
	public ItemDetails() {
		System.out.println("Default Contructor Called");
	}
	
	public ItemDetails(int itemId, String itemName, int itemCost, int quantity) {
			this.itemId = itemId;
			this.itemName = itemName;
			this.itemCost = itemCost;
			this.quantity = quantity;
		}
	
	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getQuantity() {
		return quantity;
	}
	public int setQuantity(int quantity) {
		this.quantity = quantity;
		if(quantity<0 || quantity>10) {
			return 0;
		} else {
			return quantity;
		}
	}
	public double getItemCost() {
		return itemCost;
	}
	public void setItemCost(double itemCost) {
		this.itemCost = itemCost;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + itemId;
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
		ItemDetails other = (ItemDetails) obj;
		if (itemId != other.itemId)
			return false;
		return true;
	}
	
	
}
