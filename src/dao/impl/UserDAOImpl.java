package dao.impl;

import java.util.List;

import javax.transaction.TransactionManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.orm.hibernate4.HibernateTemplate;

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
	public void saveUser() {
		System.out.println(sessionFactory);
	/*Session session = sessionFactory.openSession();
	System.out.println("dddddd2");
	Transaction transaction = session.beginTransaction();
	System.out.println("dddddd3");
		
		session.save(user);
		transaction.commit();
		
		session.close();*/
		User user = new User();
		user.setE_mail("111111");
		user.setPasword("11111");
		user.setU_id(1);
		user.setUsername("沙雕VS");
		hibernateTemplate.save(user);
	}

	public Integer deleteUser() {
		return null;
	}

	public Integer UpdateUser() {
		return null;
	}

	@Override
	public List<User> getAllUser() {
		return null;
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
