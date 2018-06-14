package service.impl;

import java.util.List;

import service.EmployeeService;
import dao.EmployeeDAO;
import dao.UserDAO;
import entity.Employee;
import entity.EmployeeAndDepartment;

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDAO employeeDAO;
	
	public EmployeeDAO getEmployeeDAO() {
		return employeeDAO;
	}
	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
	@Override
	public boolean saveEmployee(Employee employee,Integer value) {
		return employeeDAO.saveEmployee(employee,value)?true:false;
	}
	@Override
	public boolean deleteEmployee(Employee employee) {
		return employeeDAO.deleteEmployee(employee)?true:false;
	}
	@Override
	public boolean updateEmployee(Employee employee) {
		return employeeDAO.UpdateEmployee(employee)?true:false;
	}
	@Override
	public List<Employee> getAllEmployee() {
		return  employeeDAO.getAllEmployee()==null?null:employeeDAO.getAllEmployee();
	}
	@Override
	public List<EmployeeAndDepartment> getPartEmployee(String[] datas) {
		return employeeDAO.getPartEmployee(datas)==null?null:employeeDAO.getPartEmployee(datas);
	}
	@Override
	public EmployeeAndDepartment getEmployee(Employee employee) {
		return employeeDAO.getEmployee(employee)==null?null:employeeDAO.getEmployee(employee);
	}

}
