package dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;

import dao.DepartmentDAO;
import entity.Department;

public class DepartmentDAOImpl implements DepartmentDAO {
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

	public void saveDepartment(Department department) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer deleteDepartment(Department department) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer UpdateDepartment(Department department) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> getAllDepartment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> getPartDepartment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Department getDepartment() {
		// TODO Auto-generated method stub
		return null;
	}

}
