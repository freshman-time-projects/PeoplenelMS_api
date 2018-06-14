package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;
import service.EmployeeService;
import util.JsonUtil;
import util.OutContent;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;

import entity.Employee;
import entity.EmployeeAndDepartment;

public class EmployeeAction extends ActionSupport {
	private EmployeeService employeeService;
	Map<String, Object> res = new HashMap<String, Object>();

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
    //添加成功。》》》》》》前提必须得到部门的d_id的值
	public String add() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
//		String msg = JsonUtil.getStrResponse();// 获取前端信
		String msg = "{'e_id':'2','name':'xiao','age':'33','sex':'男','marry':'未','idCard':'3333','edu':'333','school':'虞城高中','mobile':'333','address':'333','email':'222','department':'3'}";
		if (msg.length() != 0) {
			JSONObject object = JSONObject.fromObject(msg);// 封装成Json对象
			Employee employee = (Employee) object.toBean(object, Employee.class);// 转成bean对象
			System.out.println();
			if (employeeService.saveEmployee(employee,object.get("department").toString()))
				OutContent.successCotent(map,"保存成功!");
			 else 
				OutContent.failCotent(map,"保存失败!");
		}
		return null;
	}
///成功》》》》只要求一定有d_id的值，其他随意
	public String romove() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();	
		String msg = JsonUtil.getStrResponse();// 获取前端信息
//		String msg = "{'e_id':'3'}";
		if (msg.length() != 0) {
			JSONObject object = JSONObject.fromObject(msg);// 封装成Json对象
			Employee employee = (Employee) object.toBean(object, Employee.class);// 转成bean对象
			if (employeeService.deleteEmployee(employee))
				OutContent.successCotent(map,"刪除成功!");
			 else 
				OutContent.failCotent(map,"刪除失败!");
		}
		return null;
	}
	//更新成功》》》》
	public String update() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();	
		/*String msg = JsonUtil.getStrResponse();// 获取前端信息
*/		String msg = "{'e_id':'25','name':'zzuao','age':'33','sex':'男','marry':'we婚','idCard':'3333','edu':'333','school':'虞城高中','mobile':'333','address':'333','email':'222'}";
		if (msg.length() != 0) {
			JSONObject object = JSONObject.fromObject(msg);// 封装成Json对象
			Employee employee = (Employee) object.toBean(object, Employee.class);// 转成bean对象
			System.out.println(employee.toString()+"5566888888899999999999999");
			if (employeeService.updateEmployee(employee))
				OutContent.successCotent(map,"更新成功!");
			 else 
				OutContent.failCotent(map,"更新失败!");
		}
		return null;
	}
//成功》》》》》》》》》》》》
	public String getAll() {
		List<Employee> list = employeeService.getAllEmployee();
		try {
			PrintWriter out = JsonUtil.getHeader();
			Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
			res.put("code", 0);
			res.put("content", list);
			String data = gson.toJson(res);
			out.print(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
    //》》》》》》》》》》成功
	public String getOne() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		List<EmployeeAndDepartment>list = new ArrayList<>();
		/*String msg = JsonUtil.getStrResponse();// 获取前端信息
*/		String msg = "{'e_id':25}";
		if (msg.length()!= 0) {
			JSONObject object = JSONObject.fromObject(msg);//封装成Json对象
			Employee employee1 = (Employee) object.toBean(object, Employee.class);// 转成bean对象
			EmployeeAndDepartment employeeAndDepartment = employeeService.getEmployee(employee1);
			System.out.println(employeeAndDepartment);
			if (employeeAndDepartment!=null){
				list.add(employeeAndDepartment);
				OutContent.content(list);
			}else 
				OutContent.content(list);
		}
		return null;
	}
/*/
	public String search() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		String msg = JsonUtil.getStrResponse();// 获取前端信息
		if (msg.length() != 0) {
			JSONObject object = JSONObject.fromObject(msg);// 封装成Json对象
			String [] datas = new String[]{(String) object.get("name"),(String) object.get("description")};
			List<EmployeeAndDepartment>list = employeeService.getPartEmployee(datas);
			if (list!=null){
				OutContent.content(list);
			}else 
				OutContent.content(list);
		}
		return null;
	}*/
}
