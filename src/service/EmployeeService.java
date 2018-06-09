package service;
import java.util.List;

import entity.Employee;
public interface EmployeeService {
	public Integer saveEmployee(Employee employee);
	public Integer deleteEmployee(Employee employee);
	public Integer updateEmployee(Employee employee);
	public List<Employee> getAllEmployee();
	public List<Employee> getPartEmployee();
	public Employee getEmployee();
}
