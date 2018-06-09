package dao;

import java.util.List;

import entity.Department;

public interface DepartmentDAO {
	public void saveDepartment();
	public Integer deleteDepartment();
	public Integer UpdateDepartment();
	public List<Department> getAllDepartment();
	public List<Department> getPartDepartment();
	public Department getDepartment();
}
