package service;

import java.util.List;

import entity.Employee;
import entity.EmployeeAndDepartment;

public interface EmployeeService {
	public boolean saveEmployee(Employee employee, String value);

	public boolean deleteEmployee(Employee employee);

	public boolean updateEmployee(Employee employee);

	public List<Employee> getAllEmployee();

	public List<EmployeeAndDepartment> getPartEmployee(String[] datas);

	public EmployeeAndDepartment getEmployee(Employee employee);
	
}
