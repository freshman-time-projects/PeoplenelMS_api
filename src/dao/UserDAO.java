package dao;

import java.util.List;

import entity.User;

public interface UserDAO {
	public boolean saveUser(User user);
	public boolean deleteUser(User user);
	public boolean UpdateUser(User user);
	public List<User> getAllUser();
	public List<User> getPartUser(String data);
	public User getUser(User user);
}
