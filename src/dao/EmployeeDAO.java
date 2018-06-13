package dao;

import java.util.List;

import entity.Employee;
public interface EmployeeDAO {
	public boolean saveEmployee(Employee employee);
	public boolean deleteEmployee(Employee employee);
	public boolean UpdateEmployee(Employee employee);
	public List<Employee> getAllEmployee();
	public List<Employee> getPartEmployee(String[] datas);
	public Employee getEmployee(Employee employee);
}
