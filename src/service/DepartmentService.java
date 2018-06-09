package service;

import java.util.List;

import entity.Department;
public interface DepartmentService {
	public Integer saveDepartment(Department department);
	public Integer deleteDepartment(Department department);
	public Integer updateDepartment(Department department);
	public List<Department> getAllDepartment();
	public List<Department> getPartDepartment();
	public Department getDepartment();
}
