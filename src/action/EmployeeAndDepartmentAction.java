package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import service.EmployeeAndDepartmentService;
import sql.GetSQLYuJu;
import util.JsonUtil;
import util.SeparatePage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;

import entity.EmployeeAndDepartment;
public class EmployeeAndDepartmentAction extends ActionSupport{
  private EmployeeAndDepartmentService employeeAndDepartmentService;
  Map<String,Object> res = new HashMap<String,Object>();
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
			res.put("code",0);
			res.put("content", list);
			String msg = gson.toJson(res);
			out.print(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	public String getSize_page(){
		  try {
			PrintWriter out = JsonUtil.getHeader();
			Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
			List<EmployeeAndDepartment> list = employeeAndDepartmentService.getAllEmployeeAndDepartment();
			List<EmployeeAndDepartment> list1 = SeparatePage.separatePage(list.size(),GetSQLYuJu.SEPERATEPAGE);
			res.put("code",0);
			res.put("content",list1);
			res.put("totalCount",list.size());
			JSONObject msg = JSONObject.fromObject(res);
			out.print(msg);
			out.close();
		  } catch (IOException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
}
