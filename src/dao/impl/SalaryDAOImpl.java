package dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate5.HibernateTemplate;

import customdefinited.ToVirtualEntity;
import dao.SalaryDAO;
import entity.Salary;
import sql.GetSQLYuJu;

public class SalaryDAOImpl implements SalaryDAO {
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
	public boolean saveSalary(Salary salary,String e_id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {

			System.out.println("%^^^"+1);
			Query query = session.createSQLQuery(GetSQLYuJu.SALARY_GET_EMPLOYEE);
			query.setString(0, e_id);
			transaction.commit();
			List<Object[]> list = query.list();
			System.out.println("%^^^"+list);
			if (list.size() == 0) {
				session.close();
				return false;
			}
			salary.setEmployee(ToVirtualEntity.getEmployee(list));
			if (session.save(salary) != null) {
				session.close();
				return true;
			}
		} catch (Exception e) {
			session.close();
		}
		return false;
	}


	@Override
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
	/* return null; */
	@Override
	public Salary getSalary() {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		System.out.println("4445454" + session);
		return null;
	}

}
