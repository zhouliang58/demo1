package model;


import java.util.Map;


public class Items {
	private int id;//编号
	private String image;//图片地址
	private String name;//名称
	private String discription;//描述
	private int price;//价格
	private String contact;//联系方式
	private int hot;//商品热度
	private String type;//商品类型
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Items(int id,String name , int price , int number){
		this.id = id;
		this.name = name;
		this.price = price;
		this.number = number;
	}
	public Items(int id, String image, String name, String discription,
			int price, String contact, int hot, int number) {
		super();
		this.id = id;
		this.image = image;
		this.name = name;
		this.discription = discription;
		this.price = price;
		this.contact = contact;
		this.hot = hot;
		this.number = number;
	}
	private int number;
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	@Override
	public String toString() {
		return "Items [id=" + id + ", image=" + image + ", name=" + name
				+ ", discription=" + discription + ", price=" + price
				+ ", contact=" + contact + ", hot=" + hot + ", type=" + type
				+ ", number=" + number + "]";
	}
	public Items(Map<String, Object> map){
		this.id = (Integer) map.get("id");
		this.name= (String)map.get("name");
		this.image = (String)map.get("image");
		this.discription = (String) map.get("discription");
		this.price = (Integer) map.get("price");
		this.contact = (String)map.get("contact");
		this.hot = (Integer)map.get("hot");
	}
	public Items() {
		super();
	}
	
	public Items(String image, String name, String discription, int price,
			String contact,int hot) {
		super();
		this.image = image;
		this.name = name;
		this.discription = discription;
		this.price = price;
		this.contact = contact;
		this.hot = hot;
	}
	public Items(int id, String image, String name, String discription,
			int price, String contact,int hot) {
		super();
		this.id = id;
		this.image = image;
		this.name = name;
		this.discription = discription;
		this.price = price;
		this.contact = contact;
		this.hot = hot;
	}
	public int getHot() {
		return hot;
	}
	public void setHot(int hot) {
		this.hot = hot;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	
}
