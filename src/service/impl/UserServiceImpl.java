package service.impl;

import java.util.List;

import service.UserService;
import dao.UserDAO;
import dao.impl.UserDAOImpl;
import entity.User;

public class UserServiceImpl implements UserService {
	private UserDAO userDao;
	public UserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	@Override
	public Integer saveUser() {
		userDao.saveUser();
		return null;
	}

	@Override
	public Integer deleteUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getPartUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser() {
		// TODO Auto-generated method stub
		return null;
	}

}
