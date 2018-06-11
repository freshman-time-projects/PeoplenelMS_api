package dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateTemplate;

import sql.GetSQLYuJu;
import dao.RecruitDAO;
import entity.Recruit;
import entity.User;

public class RecruitDAOImpl implements RecruitDAO {
	private SessionFactory sessionFactory;
	private HibernateTemplate hibernateTemplate;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public boolean saveRecruit(Recruit recruit) {
		if (hibernateTemplate.save(recruit) != null)
			return true;
		return false;
	}

	@Override
	public boolean deleteRecruit(Recruit recruit) {
		try {
			hibernateTemplate.delete(recruit);
			return true;
		} catch (DataAccessException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean UpdateRecruit(Recruit recruit) {
		try {
			hibernateTemplate.update(recruit);
			return true;
		} catch (DataAccessException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Recruit> getAllRecruit() {
		String sql = "from Recruit";
		return (List<Recruit>) hibernateTemplate.find(sql);
	}

	@Override
	public List<Recruit> getPartRecruit(String data) {
		return (List<Recruit>)hibernateTemplate.find(GetSQLYuJu.RECRUITPART,"%"+data+"%");
	}

	@Override
	public Recruit getRecruit(Recruit recruit) {
		if( hibernateTemplate.find(GetSQLYuJu.RECRUITOBJECT,new String[] { recruit.getName(),recruit.getR_id().toString()}).size()==0)
			return null;
		return (Recruit) hibernateTemplate.find(GetSQLYuJu.RECRUITOBJECT,new String[] { recruit.getName(),recruit.getR_id().toString()}).get(0);
	}

}
