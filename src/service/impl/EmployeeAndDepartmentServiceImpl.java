package service.impl;

import java.util.List;

import service.EmployeeAndDepartmentService;
import dao.EmployeeAndDepartmentDAO;
import entity.EmployeeAndDepartment;

public class EmployeeAndDepartmentServiceImpl implements EmployeeAndDepartmentService {
	private EmployeeAndDepartmentDAO employeeAndDepartmentDAO;
	public EmployeeAndDepartmentDAO getEmployeeAndDepartmentDAO() {
		return employeeAndDepartmentDAO;
	}
	public void setEmployeeAndDepartmentDAO(
			EmployeeAndDepartmentDAO employeeAndDepartmentDAO) {
		this.employeeAndDepartmentDAO = employeeAndDepartmentDAO;
	}
	@Override
	public List<EmployeeAndDepartment> getAllEmployeeAndDepartment() {
		return employeeAndDepartmentDAO.getAllEmployeeAndDepartment();
	}

}
