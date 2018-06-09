package action;

import service.EmployeeService;
import com.opensymphony.xwork2.ActionSupport;

public class EmployeeAction extends ActionSupport {
	private EmployeeService  employeeService;
	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public String addEmployee() {
		
		return "";
	}

	public String romoveEmployee() {

		return "";
	}

	public String updateEmployee() {

		return "";
	}

	public String getAllEmployee() {

		return "";
	}

	public String getEmployee() {

		return "";
	}

	public String getPartEmployee() {

		return "";
	}
}
