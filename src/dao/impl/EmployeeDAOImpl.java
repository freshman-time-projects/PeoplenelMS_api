package dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;

import dao.EmployeeDAO;
import entity.Employee;
import entity.User;

public class EmployeeDAOImpl implements EmployeeDAO{
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

	public void saveEmployee() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer deleteEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer UpdateEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getAllEmployee() {
		String sql = "from Employee";
		return (List<Employee>) hibernateTemplate.find(sql);
	}

	@Override
	public List<Employee> getPartEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

}
