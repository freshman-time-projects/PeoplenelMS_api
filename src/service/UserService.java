package service;

import java.util.List;

import entity.User;

public interface UserService {
public Integer saveUser();
public Integer deleteUser();
public Integer updateUser();
public List<User> getAllUser();
public List<User> getPartUser();
public User getUser();
}
