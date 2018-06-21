package dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateTemplate;

import sql.GetSQLYuJu;
import customdefinited.ToVirtualEntity;
import dao.EmployeeDAO;
import entity.Employee;
import entity.EmployeeAndDepartment;

public class EmployeeDAOImpl implements EmployeeDAO {
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

	/// 》》》》》》chenggong
	@Override
	public boolean saveEmployee(Employee employee, String value) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			Query query = session.createSQLQuery(GetSQLYuJu.EMPLOYEE_GET_DEPARTMENT);
			query.setString(0, value);
			transaction.commit();
			List<Object[]> list = query.list();
			if (list.size() == 0) {
				session.close();
				return false;
			}
			employee.setDepartment(ToVirtualEntity.getDepartment(list));
			if (session.save(employee) != null) {
				session.close();
				return true;
			}
		} catch (Exception e) {
			session.close();
		}
		return false;
	}

	// 》》》》》删除成功
	@Override
	public boolean deleteEmployee(Employee employee) {
		try {
			/*Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Query query = session.createSQLQuery(GetSQLYuJu.EMPLOYEE_DELETE_ONE);
			System.out.println("1");
			query.setInteger("0", employee.getE_id());
			query.executeUpdate();
			transaction.commit();
			System.out.println("2");
			List<Object[]> list = query.list();
			System.out.println("3");
			System.out.println(list + "*&*");
			System.out.println("4");
			session.close();*/
			 List<Employee>list = (List<Employee>)
			 hibernateTemplate.find(GetSQLYuJu.EMPLOYEE_DELETE_ONE,employee.getE_id());
			 if(list.size()!=0&&list!=null){
			 hibernateTemplate.delete(list.get(0));
			 return true;
			 }
			return true;
		} catch (DataAccessException e) {
			e.printStackTrace();
			return false;
		}
	}

	/// >>>>更新有bug
	@Override
	public boolean UpdateEmployee(Employee employee) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			Employee empl = session.get(Employee.class, employee.getE_id());
			System.out.println(empl + "66666666666666666666666666666");
			empl.setName(employee.getName());
			empl.setAge(employee.getAge());
			empl.setSex(employee.getSex());
			empl.setMarry(employee.getMarry());
			empl.setIdCard(employee.getIdCard());
			empl.setEdu(employee.getEdu());
			empl.setSchool(employee.getSchool());
			empl.setMobile(employee.getMobile());
			empl.setAddress(employee.getAddress());
			empl.setEmail(employee.getEmail());
			session.update(empl);
			transaction.commit();
			session.close();
			return true;
		} catch (DataAccessException e) {
			transaction.rollback();
			session.close();
			e.printStackTrace();
		}
		return true;
	}

	// 》》》》》》》获取成功
	@Override
	public List<Employee> getAllEmployee() {
		String sql = "from Employee";
		List<Employee> list = (List<Employee>) hibernateTemplate.find(sql);
		return list.size() == 0 ? null : list;
	}

	@Override
	// 模糊查询语句,通过id或者name查询
	public List<EmployeeAndDepartment> getPartEmployee(String[] datas) {
		System.out.println("datas:"+datas[0]+" "+datas[1]);
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
//<<<<<<< HEAD
//		Query query = session.createSQLQuery(GetSQLYuJu.EMPLOYEE_GET_PART);
//		System.out.println("a2" + datas[0]+"  "+datas[1]);
////		query.setString(0, "%" + datas[0] + "%");
////		query.setString(1, "%" + datas[1] + "%");
//		System.out.println("a3");
//=======
		Query query= session.createSQLQuery(GetSQLYuJu.EMPLOYEE_GET_PART);
		query.setString(0,"%"+datas[0]+"%");
		query.setString(1,"%"+datas[1]+"%");
		transaction.commit();
		List<Object[]> list = query.list();
		System.out.println("&*&*&*"+list.size());
		session.close();
		if (list == null || list.size() == 0) {
			System.out.println("**---");
			return null;
		}
		return ToVirtualEntity.getEDList(list);
	}

	// >>>>>>成功
	@Override
	public EmployeeAndDepartment getEmployee(Employee employee) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		System.out.println(employee.getE_id());
		Query query = session.createSQLQuery(GetSQLYuJu.EMPLOYEE_GET_ONE);
		query.setInteger(0, employee.getE_id()==null?-1:employee.getE_id());
		query.setString(1, employee.getEmail()==null?"":employee.getEmail());//更改
		transaction.commit();
		List<Object[]> list = query.list();
		session.close();
		if (list.size() > 0 && list != null) {
			return ToVirtualEntity.getEDList(list).get(0);
		}
		System.out.println("5555+++");
		return null;
	}
}
