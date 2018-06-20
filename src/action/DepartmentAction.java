package action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonObject;
import com.opensymphony.xwork2.ActionSupport;

import customdefinited.customdentity.CustomDepartment;
import entity.Department;
import net.sf.json.JSONObject;
import service.DepartmentService;
import util.JsonUtil;
import util.OutContent;

public class DepartmentAction extends ActionSupport {
	Map<String, Object> res = new HashMap<String, Object>();
	private DepartmentService departmentService;

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	// 成功
	public String add() throws Exception {
		try {
			// 处理跨域
			String jsoon = JsonUtil.getStrResponse();
			JSONObject jsonObject = JSONObject.fromObject(jsoon);
			Department department = (Department) JSONObject.toBean(jsonObject, Department.class);
			if (departmentService.saveDepartment(department)) {
				OutContent.successCotent(res, "保存成功!");
			} else {
				OutContent.failCotent(res, "保存失败!");
			}
			/* JSONObject json = JSONObject.fromObject(map); */
		} catch (Exception e) {
			OutContent.failCotent(res, "保存失败!");
		}
		return null;
	}

	public String romove() throws Exception {
		String msg = JsonUtil.getStrResponse();
		JSONObject json = JSONObject.fromObject(msg);
		Department department = (Department) JSONObject.toBean(json, Department.class);
		if (departmentService.deleteDepartment(department)) {
			OutContent.successCotent(res, "删除成功!");
		} else {
			OutContent.successCotent(res, "删除失败!");
		}
		return null;
	}

	// 成功
	public String update() throws Exception {
		PrintWriter out = JsonUtil.getHeader();
		/* String msg = JsonUtil.getStrResponse(); */
		String msg = "{'d_id':3,'name':'3','description':'35555554','manager':'2222'}";
		Map<String, Object> map = new HashMap<String, Object>();
		if (msg != null && msg.length() != 0) {
			JSONObject object = JSONObject.fromObject(msg);
			System.out.println("5555555" + object);
			Department department = (Department) JSONObject.toBean(object, Department.class);
			System.out.println("sss");
			if (departmentService.updateDepartment(department)) {
				OutContent.successCotent(map, "更新成功!");
			} else {
				OutContent.failCotent(map, "更新失败!");
			}
		}
		return null;
	}

	// /成功
	public String getAll() throws Exception {
		List<Department> list = departmentService.getAllDepartment();
		OutContent.content(list);
		return null;
	}

	public String getNames() throws Exception {
		List<CustomDepartment> cus = departmentService.getSum();
		List<Department> list = departmentService.getAllDepartment();
		List<String> names = new ArrayList<String>();
		List<String> values = new ArrayList<String>();
		Map<String,Object> map = new HashMap<String,Object>();
		for(CustomDepartment c:cus) {
			names.add(c.getName());
			res.put(c.getName(), Integer.parseInt(c.getSumpeople()));
		}
		map.put("names", names);
		Map<String,Object> li = new HashMap<String,Object>();
		li.put("res",res);
		li.put("col",map);
//		JSONObject message = JSONObject.fromObject(res);
//		JsonUtil.getHeader().print(message);
		OutContent.container(li);
		return null;
	}

	public String getOne() {
		// 查询单个部门时（用作更新信息）前提给一个对象

		return null;
	}

	// 成功
	public String getPart() throws Exception {
		// 模糊查询部门时，必须得给个部门名字
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			PrintWriter out = JsonUtil.getHeader();
			String msg = JsonUtil.getStrResponse();
			if (msg != null && msg.length() != 0) {
				JSONObject object = JSONObject.fromObject(msg);
				msg = (String) object.get("username");
				List<Department> list = departmentService.getPartDepartment(msg);
				OutContent.content(list);
			}
		} catch (Exception e) {
			OutContent.failCotent(map, "查找失败");
		}
		return null;
	}

	public String getSum() throws Exception {
		System.out.println("9999999999");
		OutContent.content(departmentService.getSum());
		return null;
	}

	// 部门删除的判断
	public String verify() {
		return null;
	}
}
