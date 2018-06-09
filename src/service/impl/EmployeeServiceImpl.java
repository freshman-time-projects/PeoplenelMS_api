package service.impl;

import java.util.List;

import service.EmployeeService;
import dao.EmployeeDAO;
import dao.UserDAO;
import entity.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDAO employeeDAO;
	
	public EmployeeDAO getEmployeeDAO() {
		return employeeDAO;
	}
	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
	@Override
	public Integer saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Integer deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getAllEmployee() {

		
		return  employeeDAO.getAllEmployee();
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
