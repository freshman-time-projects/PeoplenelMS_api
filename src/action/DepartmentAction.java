package action;

import service.DepartmentService;
import com.opensymphony.xwork2.ActionSupport;

public class DepartmentAction extends ActionSupport {
	private DepartmentService departmentService;

	public DepartmentService getUserService() {
		return departmentService;
	}

	public void setUserService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public String addDepartment() {
		
		return "";
	}

	public String romoveDepartment() {

		return "";
	}

	public String updateDepartment() {

		return "";
	}

	public String getAllDepartment() {

		return "";
	}

	public String getDepartment() {

		return "";
	}

	public String getPartDepartment() {

		return "";
	}
}
