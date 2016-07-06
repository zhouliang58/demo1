package service;

import java.util.List;

import dao.UserDao;
import dao.UserDaoImpl;
import model.Users;

public class UserServiceImpl implements UserService {
	private UserDao userDao;
	public UserServiceImpl(){
		userDao = new UserDaoImpl();
	}
	@Override
	public  Users findAllUsers(Users user) {
		Users resultUser = new Users();
		resultUser = null;
		List<Users> list = null;
		list = userDao.findAllUsers(user);
		if(list.size()>0){
			resultUser = (Users) list.get(0);
		}
		return resultUser;
	}

	@Override
	public boolean registerUser(Users registerUser) {
		boolean flag = userDao.registerUser(registerUser);
		return flag;
	}

}
