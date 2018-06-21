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
	public boolean saveSalary(Salary salary, String e_id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {

			System.out.println("%^^^" + 1);
			Query query = session.createSQLQuery(GetSQLYuJu.SALARY_GET_EMPLOYEE);
			query.setString(0, e_id);
			transaction.commit();
			List<Object[]> list = query.list();
			System.out.println("%^^^" + list);
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

	public boolean bonus(Salary salary) {
		/// name salary bouns department;
		return false;
	}

	public Integer getSalary() {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Query query = session.createSQLQuery(GetSQLYuJu.SALARY_SEARCH);
			List<Object[]> lists = query.list();
			transaction.commit();
			if (lists.size() > 0 && lists != null) {
				return lists.size();
			}
		} catch (HibernateException e) {
			System.out.println("sssss");
			return null;
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public Integer deleteSalary(Salary salary) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateSalary(Integer s_id) {

		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Salary updateSalary = (Salary) session.get(Salary.class, s_id);
			Integer i = Integer.parseInt(updateSalary.getSalary().toString())+2000;
			updateSalary.setSalary(i.toString());
			updateSalary.setBonus(updateSalary.getBonus()+2000);
			session.update(updateSalary);
			transaction.commit();
			session.close();
			return true;
		} catch (HibernateException e) {
			System.out.println(e);
			return false;
		}
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

}
