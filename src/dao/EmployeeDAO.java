package dao;

import java.util.List;
import entity.Employee;
public interface EmployeeDAO {
	public void saveEmployee();
	public Integer deleteEmployee();
	public Integer UpdateEmployee();
	public List<Employee> getAllEmployee();
	public List<Employee> getPartEmployee();
	public Employee getEmployee();
}
