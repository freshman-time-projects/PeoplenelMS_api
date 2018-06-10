package dao.impl;

import java.util.List;

import javax.transaction.TransactionManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateTemplate;

import sql.GetSQLYuJu;
import dao.UserDAO;
import entity.User;

public class UserDAOImpl implements UserDAO {
	private SessionFactory sessionFactory;
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public boolean saveUser(User user) {
		if (hibernateTemplate.save(user) != null)
			return true;
		return false;
	}
	@Override
	public boolean deleteUser(User user) {
		try {
			//妈的，既然是void类型
			hibernateTemplate.delete(user);
			return true;
		} catch (DataAccessException e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean UpdateUser(User user) {
		try {
			//妈的，既然是void类型
			hibernateTemplate.update(user);
			return true;
		} catch (DataAccessException e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public List<User> getAllUser() {
		String sql = "from User";
		return (List<User>) hibernateTemplate.find(sql);
	}

	private void find(String sql) {
		// TODO Auto-generated method stub

	}
	@Override   
	public List<User> getPartUser(String data) {
		return (List<User>)hibernateTemplate.find(GetSQLYuJu.GETPART,"%"+data+"%");
	}
	@Override
	public User getUser(User user) {
		if( hibernateTemplate.find(GetSQLYuJu.LOGINCHECK,new String[] { user.getUsername(), user.getPassword() }).size()==0)
			return null;
		return (User) hibernateTemplate.find(GetSQLYuJu.LOGINCHECK,new String[] { user.getUsername(), user.getPassword() }).get(0);
	}
}
