package service;

import java.util.List;

import customdefinited.customdentity.CustomDepartment;
import entity.Department;
public interface DepartmentService {
	public boolean saveDepartment(Department department);
	public boolean deleteDepartment(Department department);
	public boolean updateDepartment(Department department);
	public List<Department> getAllDepartment();
	public List<Department> getPartDepartment(String department);
	public Department getDepartment(Department department);
	public List<CustomDepartment>  getSum();

}
