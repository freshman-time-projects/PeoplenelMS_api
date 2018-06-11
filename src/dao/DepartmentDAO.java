package dao;

import java.util.List;

import customdefinited.customdentity.CustomDepartment;
import entity.Department;

public interface DepartmentDAO {
	public boolean saveDepartment(Department department);
	public boolean deleteDepartment(Department department);
	public boolean UpdateDepartment(Department department);
	public List<Department> getAllDepartment();
	public List<Department> getPartDepartment(String msg);
	public Department getDepartment(Department department);
	public List<CustomDepartment> getSum();
	
}
