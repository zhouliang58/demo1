package model;

public class Cars {
	private int itemID;
	private int userID;
	private int itemPrice;
	private String itemName;
	private String itemImage;
	private int itemNumber;
	
	@Override
	public String toString() {
		return "Cars [itemID=" + itemID + ", userID=" + userID + ", itemPrice="
				+ itemPrice + ", itemName=" + itemName + ", itemImage="
				+ itemImage + ", itemNumber=" + itemNumber + "]";
	}
	public Cars() {
		super();
	}
	public Cars(int itemID, int userID, int itemPrice, String itemName,
			String itemImage, int itemNumber) {
		super();
		this.itemID = itemID;
		this.userID = userID;
		this.itemPrice = itemPrice;
		this.itemName = itemName;
		this.itemImage = itemImage;
		this.itemNumber = itemNumber;
	}
	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemImage() {
		return itemImage;
	}
	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}
	public int getItemNumber() {
		return itemNumber;
	}
	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}
	
}
