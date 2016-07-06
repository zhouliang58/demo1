package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.JdbcUtil;


import model.Items;

public class CarsDaoImpl implements CarsDao {

	/**
	 * 添加商品到购物车
	 */
	@Override
	public boolean addItemToCar(int userID, Items item ,int number) {
		List<Object> paramList = new ArrayList<Object>();
		StringBuilder sql = new StringBuilder(
				"insert into cars(userID,itemID,itemPrice,itemName,itemImage,itemNumber) values(?,?,?,?,?,?)");
		
		//填充占位符
		int itemID = item.getId();
		int itemPrice = item.getPrice();
		String itemName = item.getName();
		String itemImage = item.getImage();
		
		paramList.add(userID);
		paramList.add(itemID);
		paramList.add(itemPrice);
		paramList.add(itemName);
		paramList.add(itemImage);
		paramList.add(number);
		
		JdbcUtil jdbcUtil = null;
		try {
			jdbcUtil = new JdbcUtil();
			jdbcUtil.getConnection(); // 获取数据库链接
						
			// 添加的商品信息
			boolean flag = jdbcUtil.updateByPreparedStatement(sql.toString(), paramList);
			if(flag==true){
				System.out.println("用户:"+userID+"添加购物车："+item.toString()+"数量"+number);
			}
			return flag;	
		} catch (SQLException e) {
			throw new RuntimeException("添加购物车异常！", e);
		} finally {
			if (jdbcUtil != null) {
				jdbcUtil.releaseConn(); // 一定要释放资源
			}
		}
	}

	/**
	 * 遍历购物车中的所有商品
	 */
	@Override
	public List<Items> ShowItemInCar(int userID) {
		List<Object> paramList = new ArrayList<Object>();
		List<Items> resultItems = new ArrayList<Items>();
		StringBuilder sql = new StringBuilder(
				"select itemID,itemPrice,itemName,itemImage,itemNumber from cars where userID=? ");		
		//填充占位符
		paramList.add(userID);
		
		JdbcUtil jdbcUtil = null;
		try {
			jdbcUtil = new JdbcUtil();
			jdbcUtil.getConnection(); // 获取数据库链接
						
			// 添加的商品信息
			List<Map<String, Object>> itemsList = jdbcUtil.findResult(sql.toString(), paramList);
			System.out.println("遍历购物车：");
			if (itemsList != null) {
				for (Map<String, Object> map : itemsList) {
					Items s = new Items();
					s.setId((Integer) map.get("itemID"));
					s.setName((String)map.get("itemName"));
					s.setImage((String)map.get("itemImage"));
					s.setPrice((Integer)map.get("itemPrice"));
					s.setNumber((Integer)map.get("itemNumber"));
					System.out.println(s.toString());
					resultItems.add(s);									
				}
			}	
		} catch (SQLException e) {
			throw new RuntimeException("遍历购物车异常！", e);
		} finally {
			if (jdbcUtil != null) {
				jdbcUtil.releaseConn(); // 一定要释放资源
			}
		}
		return resultItems;
	}

	//为购物车中已经存在的商品增加数量
	@Override
	public boolean updateItemInCar(int itemID, int userID, int number) {
		List<Object> paramList = new ArrayList<Object>();
		StringBuilder sql = new StringBuilder(
				"update cars set itemNumber=itemNumber+? where userID=? and itemID=? ");		
		//填充占位符
		paramList.add(number);
		paramList.add(userID);
		paramList.add(itemID);
		
		JdbcUtil jdbcUtil = null;
		try {
			jdbcUtil = new JdbcUtil();
			jdbcUtil.getConnection(); // 获取数据库链接
						
			// 添加的商品信息
			boolean flag = jdbcUtil.updateByPreparedStatement(sql.toString(), paramList);
			if(flag==true){
				System.out.println("用户:"+userID+"更新商品："+itemID+"数量"+number);
			}
			return flag;	
		} catch (SQLException e) {
			throw new RuntimeException("添加购物车异常！", e);
		} finally {
			if (jdbcUtil != null) {
				jdbcUtil.releaseConn(); // 一定要释放资源
			}
		}
	}
	
	//添加商品信息
	@Override
	public boolean addItem(Items additem) {
		List<Object> paramList = new ArrayList<Object>();
		StringBuilder sql = new StringBuilder(
				"insert into items(image,name,discription,price,contact,type) values(?,?,?,?,?,?)");
		
		String image = additem.getImage();
		if (image != null && !image.equals("")) {
			paramList.add(image);
		}
		String name = additem.getName();
		if (name != null && !name.equals("")) {
			paramList.add(name);
		}
		String discription = additem.getDiscription();
		if (discription != null && !discription.equals("")) {
			paramList.add(discription);
		}
		int price = additem.getPrice();
		if (price != 0) {
			paramList.add(price);
		}
		String contact = additem.getContact();
		if (contact != null && !contact.equals("")) {
			paramList.add(contact);
		}
		String type = additem.getType();
		if (type != null && !type.equals("")) {
			paramList.add(type);
		}
		
		JdbcUtil jdbcUtil = null;
		try {
			jdbcUtil = new JdbcUtil();
			jdbcUtil.getConnection(); // 获取数据库链接
						
			// 添加的商品信息
			boolean flag = jdbcUtil.updateByPreparedStatement(sql.toString(), paramList);
			if(flag==true){
				System.out.println("添加商品："+additem.toString());
			}
			return flag;	
		} catch (SQLException e) {
			throw new RuntimeException("查询所有数据异常！", e);
		} finally {
			if (jdbcUtil != null) {
				jdbcUtil.releaseConn(); // 一定要释放资源
			}
		}
	}

	//从购物车移除商品,传入用户ID和商品ID组成的数组
	@Override
	public boolean deleteItems(int userID, int[] id) {
		List<Object> paramList = new ArrayList<Object>();
		StringBuilder sql = new StringBuilder(
				"delete from cars  where userID=? and itemID in( ");	
		paramList.add(userID);
		//填充占位符
		for(int i = 0 ; i < id.length-1 ; i++){
			sql.append("?,");
			paramList.add(id[i]);
		}
		sql.append("?)");
		paramList.add(id[id.length-1]);
		JdbcUtil jdbcUtil = null;
		try {
			jdbcUtil = new JdbcUtil();
			jdbcUtil.getConnection(); // 获取数据库链接
						
			// 添加的商品信息
			boolean flag = jdbcUtil.updateByPreparedStatement(sql.toString(), paramList);
			if(flag==true){
				System.out.println("用户:"+userID+"从购物车中移除商品");
			}
			return flag;	
		} catch (SQLException e) {
			throw new RuntimeException("移除购物车异常！", e);
		} finally {
			if (jdbcUtil != null) {
				jdbcUtil.releaseConn(); // 一定要释放资源
			}
		}
	}

}
