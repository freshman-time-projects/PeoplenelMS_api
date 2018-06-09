package service;

import java.util.List;

import entity.User;

public interface UserService {
public Integer login(User user);
public Integer saveUser(User user);
public Integer deleteUser(User user);
public Integer updateUser(User user);
public List<User> getAllUser();
public List<User> getPartUser();
public User getUser();
}
