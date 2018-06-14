package dao;

import java.util.List;

import entity.Employee;
import entity.EmployeeAndDepartment;
public interface EmployeeDAO {
	public boolean saveEmployee(Employee employee,Integer value);
	public boolean deleteEmployee(Employee employee);
	public boolean UpdateEmployee(Employee employee);
	public List<Employee> getAllEmployee();
	public List<EmployeeAndDepartment> getPartEmployee(String[] datas);
	public EmployeeAndDepartment getEmployee(Employee employee);
}
