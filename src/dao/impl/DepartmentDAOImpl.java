package dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateTemplate;

import sql.GetSQLYuJu;
import customdefinited.ToVirtualEntity;
import customdefinited.customdentity.CustomDepartment;
import dao.DepartmentDAO;
import entity.Department;
import entity.Employee;

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

	public boolean saveDepartment(Department department) {
		if(hibernateTemplate.save(department)!=null)
			return true;
		return false;
	}

	@Override
	//删除部门时，需要输入验证密码，当密码正确时删除部门**************-------**********
	public boolean deleteDepartment(Department department) {
		List<Department>list = (List<Department>) hibernateTemplate.find("from Department where d_id = ?",department.getD_id());
		try {
			if(list.size()>0){
				department = list.get(0);
			hibernateTemplate.delete(department);
			System.out.println("sssss");
			return true;
			}else{
				return false;
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean UpdateDepartment(Department department) {
		List<Department>list = (List<Department>) hibernateTemplate.find("from Department where d_id = ?",department.getD_id());
		if(list.size()!=0&&list!=null){
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			Department  dep = session.get(Department.class,department.getD_id());
			System.out.println(dep+"66666666666666666666666666666");
			dep.setName(department.getName());
			dep.setDescription(department.getDescription());
			dep.setManager(department.getManager());
			session.update(dep);
			transaction.commit();
			session.close();
			return true;
			} catch (DataAccessException e) {
				return false;
			}
		}
		return false;
	}
	@Override
	public List<Department> getAllDepartment() {
		  Session session= sessionFactory.openSession();
		  Transaction transaction = session.beginTransaction();
		  Query query = session.createSQLQuery(GetSQLYuJu.DEPARTMENTALL);
		  List<Object[]>list = query.list();
		  transaction.commit();
		  session.close();
		return list.size()==0||list==null?null:ToVirtualEntity.getDList(list);
	}
  ///成功
	public List<Department> getPartDepartment(String msg) {
		List<Department> partList = (List<Department>)hibernateTemplate.find(GetSQLYuJu.DEPARTMENTPART,msg);
		if(partList.size()==0||partList==null)
			return null;
		System.out.println(partList.size()+"sssssddddd");
		return partList;
	}

	@Override
	public Department getDepartment(Department department) {
		List<Department> departmentList = (List<Department>)hibernateTemplate.find(GetSQLYuJu.DEPARTMENTMEMBER,department.getName());
		if(departmentList.size()==0||departmentList==null)
		return null;
		return departmentList.get(0);
	}

	public List<CustomDepartment> getSum() {
      Session session = sessionFactory.openSession();
      Transaction transaction = session.beginTransaction();
      List<Object[]>list_in = session.createSQLQuery(GetSQLYuJu.DEPARTMENTCOUNT_EXITS).list();
      List<Object[]>list_not = session.createSQLQuery(GetSQLYuJu.DEPARTMENTCOUNT_NOT_EXITS).list();
      transaction.commit();
      session.close();
      if((list_in==null||list_in.size()==0)&&(list_not==null||list_not.size()==0))
    	  return null;
      System.out.println("ssssss");
      return  ToVirtualEntity.getCustomDepartment(list_in,list_not);
	}
}
