package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.JdbcUtil;



import model.Items;
import model.Pager;



/**
 * 使用mysql数据库limit关键字实现分页
 */
public class ItemsDaoImpl implements ItemsDao {
	
	//根据商品名称分页查询
	@Override
	public Pager<Items> findItems(Items searchModel, int pageNum,
			int pageSize) {
		Pager<Items> result = null;
		// 存放查询参数
		List<Object> paramList = new ArrayList<Object>();
		
		String name = searchModel.getName();
		
		StringBuilder sql = new StringBuilder(
				"select id,image,name,discription,price,contact,hot from items where 1=1");
		StringBuilder countSql = new StringBuilder(
				"select count(id) as totalRecord from items where 1=1 ");
			
		if (name != null && !name.equals("")) {
			sql.append(" and name like ?");
			countSql.append(" and name like ?");
			paramList.add("%" + name + "%");
		}
		// 起始索引
		int fromIndex	= pageSize * (pageNum -1);
		
		// 使用limit关键字，实现分页
		sql.append(" limit " + fromIndex + ", " + pageSize );
		
		// 存放所有查询出的商品对象
		List<Items> itemsList = new ArrayList<Items>();
		JdbcUtil jdbcUtil = null;
		try {
			jdbcUtil = new JdbcUtil();
			jdbcUtil.getConnection(); // 获取数据库链接
			
			// 获取总记录数
			List<Map<String, Object>> countResult = jdbcUtil.findResult(countSql.toString(), paramList);
			Map<String, Object> countMap = countResult.get(0);
			int totalRecord = ((Number)countMap.get("totalRecord")).intValue();
			
			// 获取查询的商品记录
			List<Map<String, Object>> itemsResult = jdbcUtil.findResult(sql.toString(), paramList);
			if (itemsResult != null) {
				System.out.println("遍历商品：");
				for (Map<String, Object> map : itemsResult) {
					Items s = new Items(map);
					itemsList.add(s);
					System.out.println(s);
				}
			}
			
			//获取总页数
			int totalPage = totalRecord / pageSize;
			if(totalRecord % pageSize !=0){
				totalPage++;
			}
			
			// 组装pager对象
			result = new Pager<Items>(pageSize, pageNum, 
							totalRecord, totalPage, itemsList);
			
		} catch (SQLException e) {
			throw new RuntimeException("查询所有数据异常！", e);
		} finally {
			if (jdbcUtil != null) {
				jdbcUtil.releaseConn(); // 一定要释放资源
			}
		}
		return result;
	}

	//获取单个商品
	@Override
	public List<Items> getOneItem(int id) {
		List<Items> itemsList = new ArrayList<Items>();
		StringBuffer sql = new StringBuffer("select id,image,name,discription,price,contact,hot from items ");
		
		// 存放查询参数
		List<Object> paramList = new ArrayList<Object>();
		
		sql.append(" where id=? ");
		paramList.add(id);
		JdbcUtil jdbcUtil = null;
		try {
			jdbcUtil = new JdbcUtil();
			jdbcUtil.getConnection(); // 获取数据库链接
						
			// 获取查询的商品记录
			List<Map<String, Object>> itemsResult = jdbcUtil.findResult(sql.toString(), paramList);
			if (itemsResult != null) {
				for (Map<String, Object> map : itemsResult) {
					Items s = new Items(map);
					itemsList.add(s);
					System.out.println("查询单个商品："+s.toString());
				}
			}					
		} catch (SQLException e) {
			throw new RuntimeException("查询单个数据异常！", e);
		} finally {
			if (jdbcUtil != null) {
				jdbcUtil.releaseConn(); // 释放资源
			}
		}
		return itemsList;
	}

	//更新商品热度
	@Override
	public boolean addItemHot(int id) {
		StringBuffer sql = new StringBuffer("update items set hot = hot+100 where id=? ");
		
		// 存放查询参数
		List<Object> paramList = new ArrayList<Object>();
		
		paramList.add(id);
		JdbcUtil jdbcUtil = null;
		try {
			jdbcUtil = new JdbcUtil();
			jdbcUtil.getConnection(); // 获取数据库链接
						
			// 获取查询的商品记录
			boolean flag = jdbcUtil.updateByPreparedStatement(sql.toString(), paramList);
			System.out.println("更新商品热度成功");
			return flag;
		} catch (SQLException e) {
			throw new RuntimeException("查询单个数据异常！", e);
		} finally {
			if (jdbcUtil != null) {
				jdbcUtil.releaseConn(); // 释放资源
			}
		}		
	}

	/**
	 * 购买商品
	 */
	@Override
	public boolean buyItem(int userID, Items buyItem, String buy_Time) {
		List<Object> paramList = new ArrayList<Object>();
		StringBuilder sql = new StringBuilder(
				"insert into buy_items(itemID,itemName,buy_Time,userID,itemPrice,itemNumber) values(?,?,?,?,?,?)");		
		paramList.add(buyItem.getId());
		paramList.add(buyItem.getName());
		paramList.add(buy_Time);
		paramList.add(userID);
		paramList.add(buyItem.getPrice());
		paramList.add(buyItem.getNumber());
					
		JdbcUtil jdbcUtil = null;
		try {
			jdbcUtil = new JdbcUtil();
			jdbcUtil.getConnection(); // 获取数据库链接
						
			// 添加的商品信息
			boolean flag = jdbcUtil.updateByPreparedStatement(sql.toString(), paramList);
			if(flag==true){
				System.out.println("用户："+userID+"购买商品"+buyItem.toString()+"时间："+buy_Time);
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

	@Override
	public Pager<Items> typeItems(Items searchModel, int pageNum, int pageSize) {
		Pager<Items> result = null;
		// 存放查询参数
		List<Object> paramList = new ArrayList<Object>();
		
		String type = searchModel.getType();
		
		StringBuilder sql = new StringBuilder(
				"select id,image,name,discription,price,contact,hot from items where 1=1");
		StringBuilder countSql = new StringBuilder(
				"select count(id) as totalRecord from items where 1=1 ");
			
		if (type != null && !type.equals("")) {
			sql.append(" and type = ? ");
			countSql.append(" and type = ? ");
			paramList.add(type);
		}
		// 起始索引
		int fromIndex	= pageSize * (pageNum -1);
		
		// 使用limit关键字，实现分页
		sql.append(" limit " + fromIndex + ", " + pageSize );
		
		// 存放所有查询出的商品对象
		List<Items> itemsList = new ArrayList<Items>();
		JdbcUtil jdbcUtil = null;
		try {
			jdbcUtil = new JdbcUtil();
			jdbcUtil.getConnection(); // 获取数据库链接
			
			// 获取总记录数
			List<Map<String, Object>> countResult = jdbcUtil.findResult(countSql.toString(), paramList);
			Map<String, Object> countMap = countResult.get(0);
			int totalRecord = ((Number)countMap.get("totalRecord")).intValue();
			
			// 获取查询的商品记录
			List<Map<String, Object>> itemsResult = jdbcUtil.findResult(sql.toString(), paramList);
			if (itemsResult != null) {
				System.out.println("遍历商品：");
				for (Map<String, Object> map : itemsResult) {
					Items s = new Items(map);
					itemsList.add(s);
					System.out.println(s);
				}
			}
			
			//获取总页数
			int totalPage = totalRecord / pageSize;
			if(totalRecord % pageSize !=0){
				totalPage++;
			}
			
			// 组装pager对象
			result = new Pager<Items>(pageSize, pageNum, 
							totalRecord, totalPage, itemsList);
			
		} catch (SQLException e) {
			throw new RuntimeException("查询所有数据异常！", e);
		} finally {
			if (jdbcUtil != null) {
				jdbcUtil.releaseConn(); // 一定要释放资源
			}
		}
		return result;
	}
	
	//添加商品信息，发布商品
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
			throw new RuntimeException("添加商品信息异常！", e);
		} finally {
			if (jdbcUtil != null) {
				jdbcUtil.releaseConn(); // 一定要释放资源
			}
		}
	}
	

}
