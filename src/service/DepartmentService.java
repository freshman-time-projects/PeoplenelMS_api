package service;

import java.util.List;

import entity.Department;
public interface DepartmentService {
	public Integer saveDepartment();
	public Integer deleteDepartment();
	public Integer updateDepartment();
	public List<Department> getAllDepartment();
	public List<Department> getPartDepartment();
	public Department getDepartment();
}
