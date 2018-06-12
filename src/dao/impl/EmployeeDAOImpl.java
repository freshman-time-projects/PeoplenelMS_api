package dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;

import sql.GetSQLYuJu;
import dao.EmployeeDAO;
import entity.Employee;

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

	public boolean saveEmployee(Employee employee) {
		if(hibernateTemplate.save(employee)!=null)
			return false;
		return true;
	}

	@Override
	public boolean deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean UpdateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Employee> getAllEmployee() {
		String sql = "from Employee";
		return (List<Employee>) hibernateTemplate.find(sql);
	}

	@Override
	//模糊查询语句,通过id或者name查询
	public List<Employee> getPartEmployee(String[] datas) {
		List<Employee> list = (List<Employee>)hibernateTemplate.find(GetSQLYuJu.EMPLOYEE_GET_PART,new String[]{datas[0],datas[1]});
			if(list==null||list.size()==0){
				return null;
			}
		return list;
	}

	@Override
	public Employee getEmployee(Employee employee) {
		List<Employee> list = (List<Employee>)hibernateTemplate.find(GetSQLYuJu.EMPLOYEE_GET_ONE,employee.getE_id().toString());
       if(list.size()>0){
    	  return list.get(0); 
       };
		return null;
	}

}
