package model;


public class buy_items {
	private int itemID;//商品ID
	private String buy_Time;//购买时间
	private int userID;//用户ID
	private int itemPrice;//商品价格
	private int itemNumber;//商品数量
	private String itemName;//商品名称
	
	
	public buy_items() {
		super();
	}
	public buy_items(int itemID, String buy_Time, int userID, int itemPrice,
			int itemNumber, String itemName) {
		super();
		this.itemID = itemID;
		this.buy_Time = buy_Time;
		this.userID = userID;
		this.itemPrice = itemPrice;
		this.itemNumber = itemNumber;
		this.itemName = itemName;
	}
	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	public String getBuy_Time() {
		return buy_Time;
	}
	public void setBuy_Time(String buy_Time) {
		this.buy_Time = buy_Time;
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
	public int getItemNumber() {
		return itemNumber;
	}
	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	
	
}
