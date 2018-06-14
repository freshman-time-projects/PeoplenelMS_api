package dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate5.HibernateTemplate;

import customdefinited.ToVirtualEntity;
import sql.GetSQLYuJu;
import dao.EmployeeAndDepartmentDAO;
import entity.EmployeeAndDepartment;

public class EmployeeAndDepartmentDAOImpl implements EmployeeAndDepartmentDAO{
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
	public List<EmployeeAndDepartment> getAllEmployeeAndDepartment() {
	  Session session= sessionFactory.openSession();
	  Transaction transaction = session.beginTransaction();
	  Query query = session.createSQLQuery(GetSQLYuJu.SQLEDPART);
	  List<Object[]>list = query.list();
System.out.println(list.get(0).length+"dddddddddddddddddddddddddddddd");
	  transaction.commit();
	  session.close();
		return  ToVirtualEntity.getEDList(list);
	}

}
