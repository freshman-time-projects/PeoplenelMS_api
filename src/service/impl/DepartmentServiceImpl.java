package service.impl;

import java.util.List;

import service.DepartmentService;
import customdefinited.customdentity.CustomDepartment;
import dao.DepartmentDAO;
import entity.Department;
public class DepartmentServiceImpl implements DepartmentService {
	private DepartmentDAO departmentDAO;
	public DepartmentDAO getDepartmentDAO() {
		return departmentDAO;
	}

	public void setDepartmentDAO(DepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
	}

	@Override
	public boolean saveDepartment(Department department) {
		return departmentDAO.saveDepartment(department)?true:false;
	}

	@Override
	public boolean deleteDepartment(Department department) {
		return departmentDAO.deleteDepartment(department)?true:false;
	}

	@Override
	public boolean updateDepartment(Department department) {
		System.out.println("ssssssss");
		return departmentDAO.UpdateDepartment(department)?true:false;
	}

	@Override
	public List<Department> getAllDepartment() {
			return departmentDAO.getAllDepartment()==null?null:departmentDAO.getAllDepartment();
	}

	@Override
	public List<Department> getPartDepartment(String msg) {
		System.out.println("211111111");
		return departmentDAO.getPartDepartment(msg)==null?null:departmentDAO.getPartDepartment(msg);
	}

	@Override
	public Department getDepartment(Department department) {
		return departmentDAO.getDepartment(department)==null?null:departmentDAO.getDepartment(department);
	}
	
	
	@Override
	public List<CustomDepartment>  getSum(){
		return departmentDAO.getSum()==null?null:departmentDAO.getSum();
	}
}
