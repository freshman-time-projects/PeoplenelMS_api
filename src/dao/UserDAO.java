package dao;

import java.util.List;

import entity.User;

public interface UserDAO {
	public void saveUser();
	public Integer deleteUser();
	public Integer UpdateUser();
	public List<User> getAllUser();
	public List<User> getPartUser();
	public User getUser();
}
