package dao;

import java.util.List;

import entity.Department;

public interface DepartmentDAO {
	public void saveDepartment(Department department);
	public Integer deleteDepartment(Department department);
	public Integer UpdateDepartment(Department department);
	public List<Department> getAllDepartment();
	public List<Department> getPartDepartment();
	public Department getDepartment();
}
