package service;

import model.Users;

public interface UserService {
	//从数据库里面检验用户信息，登录检测
	public Users findAllUsers(Users user);
	
	//注册用户信息
	public boolean registerUser(Users registerUser);
}
