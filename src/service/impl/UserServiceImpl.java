package service.impl;

import java.util.List;

import service.UserService;

import com.opensymphony.xwork2.ActionSupport;

import dao.UserDAO;
import entity.User;

public class UserServiceImpl extends ActionSupport implements UserService {
	private UserDAO userDao;
	public UserDAO getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	public Integer login(User user){
		if(userDao.getUser(user)==null)
		return 0;
		
		return 1;
	}
	@Override
	public boolean saveUser(User user) {
		if(userDao.saveUser(user))
		    return true;
		return false;
	}

	@Override
	public boolean deleteUser(User user) {
		if(userDao.deleteUser(user))
			return true;
		return false;
	}

	@Override
	public boolean updateUser(User user) {
		if(userDao.UpdateUser(user))
			return true;
		return false;
	}

	@Override
	public List<User> getAllUser() {
		return userDao.getAllUser();
	}

	@Override
	public List<User> getPartUser(String data) {
		return userDao.getPartUser(data);
	}

	@Override
	public User getUser(User user) {
		return userDao.getUser(user);
	}

}
