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

	public boolean bonus(Salary salary) {
		 
		
		
		return false;
	}

	public Salary getSalary() {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		System.out.println("4445454"+session);
		return null;
	}
	
}
