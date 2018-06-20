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

	@Override
	public Integer login(User user){
		User u  = userDao.getUser(user);
		if(u==null||!u.getState().equals("1"))
		return -1;
		return 1;
	}
	@Override
	public boolean saveUser(User user) {
		if(userDao.saveUser(user)) {
			try {
//				MailUtils.sendMail(user.getEmail(), user.getCode());
			} catch (Exception e) {
				System.out.println("未知错误");
			}
			return true;
		}
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
	@Override
	public User active(String code) {
		return userDao.getUserByCode(code);
	}
	@Override
	public User pass(String email,String name) {
		return userDao.pass(email,name);
	}

}
