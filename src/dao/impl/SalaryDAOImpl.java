package dao.impl;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate5.HibernateTemplate;

import sql.GetSQLYuJu;
import customdefinited.ToVirtualEntity;
import customdefinited.customdentity.EmployeeSalary;
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
		 ///name salary bouns department;
		return false;
	}

	public Integer getSalary() {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Query query = session.createSQLQuery(GetSQLYuJu.SALARY_SEARCH);
			List<Object[]>lists = query.list();
			transaction.commit();
			if(lists.size()>0&&lists!=null){
			 return lists.size();
			 }
		} catch (HibernateException e) {
			System.out.println("sssss");
			return null;
		}finally{
			session.close();
		}
		return null;
	}
	
}
