package service;
import java.util.List;
import entity.Employee;
public interface EmployeeService {
	public Integer saveEmployee();
	public Integer deleteEmployee();
	public Integer updateEmployee();
	public List<Employee> getAllEmployee();
	public List<Employee> getPartEmployee();
	public Employee getEmployee();
}
