package dao;

import java.util.List;

import model.Items;

public interface CarsDao {
	//添加商品和用户信息到购物车中(添加的商品必须是购物车中不存在的)
	public boolean addItemToCar(int userID , Items item , int number);
	
	//根据用户ID，遍历购物车，返回所有的商品信息
	public List<Items> ShowItemInCar(int userID );
	
	//为购物车中已经存在的商品增加数量
	public boolean updateItemInCar(int itemID,int userID,int number);
	
	//添加商品信息
	public boolean addItem(Items additem);
	
	//删除商品信息
	public boolean deleteItems(int userID , int id[]);
}
