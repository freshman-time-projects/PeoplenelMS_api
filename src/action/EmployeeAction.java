package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;

import entity.Employee;
import entity.EmployeeAndDepartment;
import entity.Salary;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import service.DepartmentService;
import service.EmployeeService;
import service.RecruitService;
import service.SalaryService;
import util.JsonUtil;
import util.OutContent;

public class EmployeeAction extends ActionSupport {
	private EmployeeService employeeService;
	private SalaryService salaryService;
	private DepartmentService departmentService;
	private RecruitService recruitService;
	Map<String, Object> res = new HashMap<String, Object>();

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public Map<String, Object> getRes() {
		return res;
	}

	public void setRes(Map<String, Object> res) {
		this.res = res;
	}

	public SalaryService getSalaryService() {
		return salaryService;
	}

	public void setSalaryService(SalaryService salaryService) {
		this.salaryService = salaryService;
	}

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public RecruitService getRecruitService() {
		return recruitService;
	}

	public void setRecruitService(RecruitService recruitService) {
		this.recruitService = recruitService;
	}

	// 添加成功。》》》》》》前提必须得到部门的d_id的值
	public String add() throws Exception {
		String msg = JsonUtil.getStrResponse();// 获取前端信
		if (msg.length() != 0) {
			JSONObject object = JSONObject.fromObject(msg);// 封装成Json对象
			Employee employee = (Employee) JSONObject.toBean(object, Employee.class);// 转成bean对象
			Salary salary = new Salary();
			salary.setName(employee.getName());
			salary.setSalary("20000");
			if (employeeService.saveEmployee(employee, object.get("department").toString())
					&& salaryService.saveSalary(salary, object.get("email").toString()))
				OutContent.successCotent(res, "保存成功!");
			else
				OutContent.failCotent(res, "保存失败!");
		}
		return null;
	}

	/// 成功》》》》只要求一定有d_id的值，其他随意
	public String romove() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		String msg = JsonUtil.getStrResponse();// 获取前端信息
		System.out.println("ssssa123" + msg);
		// String msg = "{'e_id':'3'}";
		if (msg.length() != 0) {
			JSONObject object = JSONObject.fromObject(msg);// 封装成Json对象
			Employee employee = (Employee) JSONObject.toBean(object, Employee.class);// 转成bean对象
			if (employeeService.deleteEmployee(employee))
				OutContent.successCotent(map, "刪除成功!");
			else
				OutContent.failCotent(map, "刪除失败!");
		}
		return null;
	}

	// 更新成功》》》》
	public String update() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		String msg = JsonUtil.getStrResponse();// 获取前端信息
		System.out.println("msg" + msg);
		// String msg =
		// "{'e_id':'25','name':'zzuao','age':'33','sex':'男','marry':'we婚','idCard':'3333','edu':'333','school':'虞城高中','mobile':'333','address':'333','email':'222'}";
		if (msg.length() != 0) {
			JSONObject object = JSONObject.fromObject(msg);// 封装成Json对象
			System.out.println("object" + object);
			Employee employee = (Employee) JSONObject.toBean(object, Employee.class);// 转成bean对象
			System.out.println("******" + employee);

			if (employeeService.updateEmployee(employee))
				OutContent.successCotent(map, "更新成功!");
			else
				OutContent.failCotent(map, "更新失败!");
		}
		return null;
	}

	// 成功》》》》》》》》》》》》
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

	// 》》》》》》》》》》成功
	public String getOne() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		List<EmployeeAndDepartment> list = new ArrayList<EmployeeAndDepartment>();
		/*
		 * String msg = JsonUtil.getStrResponse();// 获取前端信息
		 */ String msg = "{'e_id':25}";
		if (msg.length() != 0) {
			JSONObject object = JSONObject.fromObject(msg);// 封装成Json对象
			Employee employee1 = (Employee) JSONObject.toBean(object, Employee.class);// 转成bean对象
			EmployeeAndDepartment employeeAndDepartment = employeeService.getEmployee(employee1);
			System.out.println(employeeAndDepartment);
			if (employeeAndDepartment != null) {
				list.add(employeeAndDepartment);
				OutContent.content(list);
			} else
				OutContent.content(list);
		}
		return null;
	}

	public String search() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		String msg = JsonUtil.getStrResponse();// 获取前端信息
		System.out.println("msg" + msg);
		if (msg.length() != 0) {
			JSONObject object = JSONObject.fromObject(msg);

			System.out.println("msg11");
			String[] datas = new String[] { (String) object.get("name"), (String) object.get("department") };

			System.out.println("2");
			List<EmployeeAndDepartment> list = employeeService.getPartEmployee(datas);

			System.out.println("3");
			if (list != null) {
				OutContent.content(list);
			} else
				OutContent.content(list);
		}
		return null;
	}

	public String count() throws Exception {
		PrintWriter out = JsonUtil.getHeader();
		Integer employeeCount = employeeService.getAllEmployee().size();
		Integer departmentCount = departmentService.getAllDepartment().size();
		Integer recruitCount = recruitService.getAllRecruit("all").size();
		Integer faceCount = recruitService.getAllRecruit("1").size();
		res.put("employeeCount", employeeCount);
		res.put("departmentCount", departmentCount);
		res.put("recruitCount", recruitCount);
		res.put("faceCount", faceCount);
		JSONObject message = JSONObject.fromObject(res);
			out.print(message);
		return null;
	}

}
