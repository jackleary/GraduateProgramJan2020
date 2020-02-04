package com.mastek.training.myshop;

public class Item implements Comparable<Item> // provides default sorting for TreeSet
{
	
	private int itemId;
	private String itemName;
	private int itemQuantity;
	private double itemPrice;
	
	public Item() {
		// TODO Auto-generated constructor stub
	}
	
	public Item(int itemId, String itemName, double itemPrice, int itemQuantity) {
		// TODO Auto-generated constructor stub
		setItemId(itemId);
		setItemName(itemName);
		setItemPrice(itemPrice);
		setItemQuantity(itemQuantity);
		
	}
	

	public Item(int itemId) {
		// TODO Auto-generated constructor stub
		setItemId(itemId);
	}

	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemQuantity() {
		return itemQuantity;
	}
	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	public double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
	
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", itemQuantity=" + itemQuantity + ", itemPrice="
				+ itemPrice + "]";
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
		Item other = (Item) obj;
		if (itemId != other.itemId)
			return false;
		return true;
	}
	
	// TreeSet uses compareTo for default order
	@Override
	public int compareTo(Item anotherItem) {
		// TODO Auto-generated method stub
		// return a number:
		// +ve: current object is greater than anotherItem
		// 0: current object is equal to anotherItem
		// -ve: current object is less than anotherItem
		System.out.println("Comparing Items");
		// return this.getItemId()-anotherItem.getItemId(); // ASC
		// return anotherItem.getItemId()-this.getItemId(); // DESC
		return this.getItemId()-anotherItem.getItemId();
		// we all need to compare the unique/key values for managing order
	}

	
	

}
