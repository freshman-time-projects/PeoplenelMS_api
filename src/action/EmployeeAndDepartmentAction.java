package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import service.EmployeeAndDepartmentService;
import util.JsonUtil;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;

import entity.EmployeeAndDepartment;

public class EmployeeAndDepartmentAction extends ActionSupport{
  private EmployeeAndDepartmentService employeeAndDepartmentService;
	public EmployeeAndDepartmentService getEmployeeAndDepartmentService() {
	return employeeAndDepartmentService;
}
public void setEmployeeAndDepartmentService(
		EmployeeAndDepartmentService employeeAndDepartmentService) {
	this.employeeAndDepartmentService = employeeAndDepartmentService;
}
	public String getAllEmployeeAndDepartment(){
		  try {
			PrintWriter out = JsonUtil.getHeader();
			Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
			List<EmployeeAndDepartment> list = employeeAndDepartmentService.getAllEmployeeAndDepartment();
			String msg = gson.toJson(list);
			out.println(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
}
