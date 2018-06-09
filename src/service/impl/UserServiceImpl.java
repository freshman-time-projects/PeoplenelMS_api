package service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

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
		HttpSession session = ServletActionContext.getRequest().getSession();
		String name =(String)session.getAttribute("login");
		if(name==null){
			return 0;
		}
		return 1;
	}
	@Override
	public Integer saveUser(User user) {
		userDao.saveUser(user);
		return null;
	}

	@Override
	public Integer deleteUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllUser() {
		
		return userDao.getAllUser();
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
