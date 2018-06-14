package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;
import service.DepartmentService;   
import util.GetRequestorResponse;
import util.JsonUtil;
import util.OutContent;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;

import entity.Department;

public class DepartmentAction extends ActionSupport {
	private DepartmentService departmentService;

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	// 成功
	public String add() throws Exception {
		HttpSession session = GetRequestorResponse.getSession();
		HttpServletRequest request = GetRequestorResponse.getRequest();
		Gson gson = new Gson();
		PrintWriter out = JsonUtil.getHeader();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			// 处理跨域
			String jsoon = JsonUtil.getStrResponse();
			/*
			 * String jsoon =
			 * "{'name':'12','description':'45',}";//**************
			 */JSONObject jsonObject = JSONObject.fromObject(jsoon);
			Department department = (Department) JSONObject.toBean(jsonObject,
					Department.class);
			if (departmentService.saveDepartment(department)) {
				OutContent.successCotent(map,"保存成功!");
			} else {
				OutContent.failCotent(map,"保存失败!");
			}
			String data = gson.toJson(map);
			/* JSONObject json = JSONObject.fromObject(map); */
			out.print(data);
		} catch (Exception e) {
			OutContent.failCotent(map,"保存失败!");
		}
		return null;
	}
//成功"{'d_id':1,'name':'3','description':'34','manager':'2222'}"; 
	public String romove() throws Exception {
		PrintWriter out = JsonUtil.getHeader();
		String msg =JsonUtil.getStrResponse();
		Map<String, Object> map = new HashMap<String, Object>();
		JSONObject json = JSONObject.fromObject(msg);
		Department department = (Department) json
				.toBean(json, Department.class);
		if (departmentService.deleteDepartment(department)) {
			OutContent.successCotent(map,"删除成功!");
		} else {
			map.put("code", 3);
			map.put("msg", "删除失败");
		}
		
		JSONObject object = JSONObject.fromObject(map);
		out.print(object);
		return null;
	}

	// 成功
	public String update() throws Exception {
		PrintWriter out = JsonUtil.getHeader();
		/* String msg = JsonUtil.getStrResponse(); */
		String msg = "{'d_id':1,'name':'3','description':'34','manager':'2222'}";
		Map<String, Object> map = new HashMap<String, Object>();
		if (msg != null && msg.length() != 0) {
			JSONObject object = JSONObject.fromObject(msg);
			System.out.println("5555555" + object);
			Department department = (Department) object.toBean(object,
					Department.class);
			System.out.println("sss");
			if (departmentService.updateDepartment(department)) {
				OutContent.successCotent(map,"更新成功!");
			} else {
				OutContent.failCotent(map,"更新失败!");
			}
		}
		return null;
	}

	// /成功
	public String getAll() throws Exception {
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		List<Department> list = departmentService.getAllDepartment();
		OutContent.content(list);
		return null;
	}

	public String getOne() {
        //查询单个部门时（用作更新信息）前提给一个对象
		
		return null;
	}

	//成功
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
			OutContent.failCotent(map,"查找失败");
		}
		return null;
	}

	public String getSum() throws Exception {
		System.out.println("9999999999");
		OutContent.content(departmentService.getSum());
		return null;
	}
	//部门删除的判断
   public String verify (){
	   return null ;
   }
}
