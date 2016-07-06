package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.JdbcUtil;

import model.Users;

public class UserDaoImpl implements UserDao {

	@Override
	public  List<Users> findAllUsers(Users user) {
		//sql查询的参数
		List<Object> paramList = new ArrayList<Object>();
		
		//查询结果返回的Users
		List<Users> UserList = new ArrayList<Users>();
		StringBuilder sql = new StringBuilder(
				"select * from users where username=? and password=? ");		
		//添加查询参数
		paramList.add(user.getUsername());
		paramList.add(user.getPassword());
		JdbcUtil jdbcUtil = null;
		try {
			jdbcUtil = new JdbcUtil();
			jdbcUtil.getConnection(); // 获取数据库链接
						
			// 获取查询的用户记录
			List<Map<String, Object>> listResult = jdbcUtil.findResult(sql.toString(), paramList);
			if (listResult != null) {
				for (Map<String, Object> map : listResult) {
					Users u = new Users(map);
					UserList.add(u);
					System.out.println("用户检验成功！"+u.toString());
				}
			}				
		} catch (SQLException e) {
			throw new RuntimeException("查询单个用户信息异常！", e);
		} finally {
			if (jdbcUtil != null) {
				jdbcUtil.releaseConn(); // 释放资源
			}
		}
		return UserList;
	}
	
	
	@Override
	public boolean registerUser(Users registerUser) {
		
		List<Object> paramList = new ArrayList<Object>();
		StringBuilder sql = new StringBuilder(
				"insert into users(username,password,contact,address) values(?,?,?,?)");
		
		String username = registerUser.getUsername();
		if (username != null && !username.equals("")) {
			paramList.add(username);
		}
		String password = registerUser.getPassword();
		if (password != null && !password.equals("")) {
			paramList.add(password);
		}
		String contact = registerUser.getContact();
		if (contact != null && !contact.equals("")) {
			paramList.add(contact);
		}
		String address = registerUser.getAddress();
		if (address != null && !address.equals("")) {
			paramList.add(address);
		}
					
		JdbcUtil jdbcUtil = null;
		try {
			jdbcUtil = new JdbcUtil();
			jdbcUtil.getConnection(); // 获取数据库链接
						
			// 添加用户信息
			boolean flag = jdbcUtil.updateByPreparedStatement(sql.toString(), paramList);
			if(flag==true){
				System.out.println("添加的用户信息："+registerUser.toString());
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

}
