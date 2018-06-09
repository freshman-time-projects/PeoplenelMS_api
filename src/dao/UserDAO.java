package dao;

import java.util.List;

import entity.User;

public interface UserDAO {
	public void saveUser(User user);
	public Integer deleteUser(User user);
	public Integer UpdateUser(User user);
	public List<User> getAllUser();
	public List<User> getPartUser();
	public User getUser();
}
