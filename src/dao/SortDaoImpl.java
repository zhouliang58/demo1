package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.JdbcUtil;
import model.Items;
import model.Pager;

public class SortDaoImpl implements SortDao {
	
	//根据价格对商品排序
	@Override
	public Pager<Items> SortByPrice(Items searchModel, int pageNum, int pageSize) {
		Pager<Items> result = null;
		// 存放查询参数
		List<Object> paramList = new ArrayList<Object>();
		
		String name = searchModel.getName();
		String type = searchModel.getType();
		StringBuilder sql = new StringBuilder(
				"SELECT id,image,NAME,discription,price,contact,hot FROM items WHERE 1=1 ");
		StringBuilder countSql = new StringBuilder(
				"select count(id) as totalRecord from items where 1=1 ");
			
		if (name != null && !name.equals("")) {
			sql.append(" and name like ?");
			countSql.append(" and name like ?");
			paramList.add("%" + name + "%");
		}
		if (type != null && !type.equals("")) {
			sql.append(" and type = ? ");
			countSql.append(" and type = ? ");
			paramList.add(type);
		}
		sql.append(" ORDER BY price ");
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
	
	//根据人气对商品排序
	@Override
	public Pager<Items> SortByHot(Items searchModel, int pageNum, int pageSize) {
		Pager<Items> result = null;
		// 存放查询参数
		List<Object> paramList = new ArrayList<Object>();
		
		String name = searchModel.getName();
		String type = searchModel.getType();
		StringBuilder sql = new StringBuilder(
				"SELECT id,image,NAME,discription,price,contact,hot FROM items WHERE 1=1 ");
		StringBuilder countSql = new StringBuilder(
				"select count(id) as totalRecord from items where 1=1 ");
			
		if (name != null && !name.equals("")) {
			sql.append(" and name like ?");
			countSql.append(" and name like ?");
			paramList.add("%" + name + "%");
		}
		if (type != null && !type.equals("")) {
			sql.append(" and type = ? ");
			countSql.append(" and type = ? ");
			paramList.add(type);
		}
		sql.append(" ORDER BY hot desc  ");
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

}
