package dao.impl;

import java.util.List;

import javax.transaction.TransactionManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.orm.hibernate5.HibernateTemplate;
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
	@Test
	public void saveUser(User user) {
		user.setE_mail("111111");
		user.setPasword("11111");
		user.setU_id(1);
		user.setUsername("沙雕VS");
		hibernateTemplate.save(user);
	}

	public Integer deleteUser(User user) {
		return null;
	}

	public Integer UpdateUser(User user) {
		return null;
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
	public User getUser() {
		return null;
	}

	@Override
	public List<User> getPartUser() {
		// TODO Auto-generated method stub
		return null;
	}
}
