package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import service.EmployeeService;
import util.JsonUtil;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;

import entity.Employee;

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
		 List<Employee> list = employeeService.getAllEmployee();
		 try {
		   PrintWriter out = JsonUtil.getHeader();
			Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
			String msg = gson.toJson(list);
			out.println(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
			return null;
	}

	public String getEmployee() {

		return "";
	}

	public String getPartEmployee() {

		return "";
	}
}
