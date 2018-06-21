package dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
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
		if (!hibernateTemplate
				.find("from entity.User u where u.username =? or u.email=?", user.getUsername(), user.getEmail())
				.isEmpty()) {
			System.out.println("已存在");
			return false;
		} else {
			System.out.println("不存在");
			user.setRole("1");
			user.setState("0");
			hibernateTemplate.save(user);
			return true;
		}
	}

	@Override
	public boolean deleteUser(User user) {
		List<User> list = (List<User>) hibernateTemplate.find("from User where u_id = ?", user.getU_id());
		try {
			if (list.size() > 0) {
				user = list.get(0);
				hibernateTemplate.delete(user);
			}
			return true;
		} catch (DataAccessException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean UpdateUser(User user) {
		try {
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
		return (List<User>) hibernateTemplate.find(GetSQLYuJu.GETPART, "%" + data + "%");
	}

	@Override
	public User getUser(User user) {
		if (hibernateTemplate.find(GetSQLYuJu.LOGINCHECK,
				new String[] { user.getUsername(), user.getUsername(), user.getPassword() }).size() == 0)
			return null;
		return (User) hibernateTemplate.find(GetSQLYuJu.LOGINCHECK,
				new String[] { user.getUsername(), user.getUsername(), user.getPassword() }).get(0);
	}

	@Override
	public User getUserByCode(String code) {
		return (User) hibernateTemplate.find(GetSQLYuJu.USER_FIND_BYNAME, code).get(0);
	}

	@Override
	public User pass(String email, String name) {
		// Session session = sessionFactory.openSession();
		// Transaction transaction = session.beginTransaction();
		// Query query = session.createSQLQuery(GetSQLYuJu.RECRUIT_PASS);
		// query.setString(0, email);
		// System.out.println("11111"+" "+email);
		// List<User> list = (List<User>)query.list();
		// System.out.println("1111122"+list.size());
		// transaction.commit();
		return (User) hibernateTemplate.find(GetSQLYuJu.RECRUIT_PASS, name, email).get(0);
	}
}
