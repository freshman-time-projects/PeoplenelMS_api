package service;

import java.util.List;

import entity.User;

public interface UserService {
public Integer login(User user);
public boolean saveUser(User user);
public boolean deleteUser(User user);
public boolean updateUser(User user);
public List<User> getAllUser();
public List<User> getPartUser(String string);
public User getUser(User user);
public User active(String code);
public User pass(String email,String name);
}
