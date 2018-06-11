package dao.impl;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.orm.hibernate5.HibernateTemplate;

import dao.SalaryDAO;
import entity.Salary;
public class SalaryDAOImpl implements SalaryDAO{
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

	public void saveSalary(Salary salary) {
		
	}

	public Integer deleteSalary(Salary salary) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer UpdateSalary(Salary salary) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Salary> getAllSalary() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Salary> getPartSalary() {
		// TODO Auto-generated method stub
		return null;
	}
	
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		/*return null;*/
	public Salary getSalary() {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		System.out.println("4445454"+session);
		return null;
	}
	
}
