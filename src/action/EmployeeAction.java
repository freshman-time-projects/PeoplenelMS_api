package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import service.EmployeeService;
import util.JsonUtil;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;

import entity.Employee;

public class EmployeeAction extends ActionSupport {
	private EmployeeService  employeeService;
	Map<String, Object> res = new HashMap<String, Object>();
	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public String add() {
		
		return null;
	}

	public String romove() {

		return null;
	}

	public String update() {

		return null;
	}

	public String getAll() {
		 List<Employee> list = employeeService.getAllEmployee();
		 try {
		   PrintWriter out = JsonUtil.getHeader();
			Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
			res.put("code",0);
			res.put("content",list);
			String data = gson.toJson(res);
			out.print(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
			return null;
	}

	public String getOne() {

		
		
		return null;
	}

	public String getPart() {

		return null;
	}
}
