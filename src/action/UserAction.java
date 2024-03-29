package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import entity.Employee;
import entity.User;
import net.sf.json.JSONObject;
import service.EmployeeService;
import service.UserService;
import sql.GetSQLYuJu;
import util.GetRequestorResponse;
import util.JsonUtil;
import util.ObjectToJson;
import util.OutContent;
import util.SeparatePage;
import util.UUIDUtils;

public class UserAction extends ActionSupport {
	private UserService userService;
	private EmployeeService employeeService;
	private Map<String, Object> res = new HashMap<String, Object>();
	private String code;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	/// 测试成功
	public String login() throws Exception {
		HttpSession session = GetRequestorResponse.getSession();
		HttpServletRequest request = GetRequestorResponse.getRequest();
		Gson gson = new Gson();
		PrintWriter out = JsonUtil.getHeader();
		try {
			// 处理跨域
			String jsoon = JsonUtil.getStrResponse();
			JSONObject jsonObject = JSONObject.fromObject(jsoon);
			User user = (User) JSONObject.toBean(jsonObject, User.class);
			System.out.println("**&&" + user.toString());
			/*
			 * User user = new User(); user.setUsername("ee"); user.setPassword("ee");
			 */
			// 判断是否登录，登录返回1，相反返回0
			int flag = -1;
			flag = userService.login(user);
			// Gson 传输数据、
			if (flag > 0 && request.getSession().getAttribute("username") != null) {
				res.put("code", 2);
				res.put("msg", "您已登录，请不要重复登录");
				flag = 0;
			}
			if (flag > 0) {
				Employee employee = new Employee();
				user = userService.getUser(user);
				System.out.println("uuuuu" + user.toString() + "  " + user.getEmail());
				employee.setEmail(user.getEmail());
				System.out.println("qqqqq" + employee.getEmail());

				ActionContext.getContext().getSession().put("username", user.getUsername());
				System.out.println("uuuus" + ActionContext.getContext().getSession().get("username"));
				res.put("code", 0);
				res.put("msg", "欢迎回来");
				res.put("content", userService.getUser(user));
				res.put("dataSource", employeeService.getEmployee(employee));
			}
			if (flag < 0) {
				res.put("code", 1);
				res.put("msg", "登录失败，用户名或密码错误或您的账号未激活");
			}
			System.out.println("**&&" + flag);
			String msg = gson.toJson(res);
			out.print(msg);
		} catch (Exception e) {
			res.put("code", 6);
			res.put("msg", "测试接口");
			JSONObject msg = JSONObject.fromObject(res);
			System.out.println(msg);
			out.print(msg);
			e.printStackTrace();
		}
		return null;
	}

	public String active() throws Exception {
		System.out.println("code"+code);
		User user = userService.active(code);
		if(user!=null) {
			user.setState("1");
			user.setCode("ACTIVED");
			userService.updateUser(user);
			return SUCCESS;
		}
		else
			OutContent.failCotent(res, "您的激活码已经失效，请重新获取！");
	return null;
	}

	// 成功
	public String add() throws Exception {
		PrintWriter out = JsonUtil.getHeader();
		Gson gson = new Gson();
		String jsoon = JsonUtil.getStrResponse();
		JSONObject jsonobject = JSONObject.fromObject(jsoon);
		String code = UUIDUtils.getUUID() + UUIDUtils.getUUID();
		User user = (User) JSONObject.toBean(jsonobject, User.class);
		user.setCode(code);
		if (userService.saveUser(user)) {
			res.put("code", 0);
			res.put("msg", "注册成功，请去登录");
		} else {
			res.put("code", 3);
			res.put("msg", "该用户名或邮箱已经被注册了哦~");
		}
		String msg = gson.toJson(res);
		out.print(msg);
		return null;
	}

	//// 成功
	public String remove() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String jsoon = JsonUtil.getStrResponse();
			// String jsoon =
			// "{'u_id':8,'username':'dddd','password':'333','email':'eerrrf','role':'ddddd','code':'234d'}";
			JSONObject jsonobject = JSONObject.fromObject(jsoon);
			User user = (User) JSONObject.toBean(jsonobject, User.class);
			if (userService.deleteUser(user))
				OutContent.successCotent(map, "更新成功");
			else
				OutContent.successCotent(map, "更新失败");

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	//// 成功
	public String update() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			/* String jsoon = JsonUtil.getStrResponse(); */
			String jsoon = "{'u_id':8,'username':'dddd','password':'333','email':'eerrrf','role':'ddddd','code':'234d'}";
			JSONObject jsonobject = JSONObject.fromObject(jsoon);
			User user = (User) JSONObject.toBean(jsonobject, User.class);
			if (userService.updateUser(user)) {
				OutContent.successCotent(map, "更新成功");
			} else {
				OutContent.successCotent(map, "更新失败");
			}
		} catch (IOException e) {
			e.printStackTrace();
			OutContent.successCotent(map, "更新失败");
		}
		return null;
	}

	// 成功
	public String getAll_page() throws IOException {
		System.out.println("size1");
		Integer userCount = userService.getAllUser().size();
		System.out.println("size" + userCount);
		List<User> list = userService.getAllUser();
		PrintWriter out = JsonUtil.getHeader();
		Map<String, Object> map = new HashMap<String, Object>();
		if (list != null && list.size() != 0) {
			try {
				map.put("code", 0);
				map.put("content", SeparatePage.ueerSeparatePage(list.size(), GetSQLYuJu.USER_ALL_PAGE));
				map.put("userCount", userCount);
				Gson gson = new Gson();
				JSONObject msg = JSONObject.fromObject(map);
				out.println(msg);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			map.put("code", 3);
			map.put("content", "操作异常");
			Gson gson = new Gson();
			JSONObject msg = JSONObject.fromObject(map);
			out.println(msg);
		}
		return null;
	}

	public String get() {

		return "";
	}

	public String getPartUser() {
		try {
			String jsoon = JsonUtil.getStrResponse();
			JSONObject jsonobject = JSONObject.fromObject(jsoon);
			String data = jsonobject.getString("data");
			List<User> list = userService.getPartUser(data);
			if (list != null)
				GetRequestorResponse.getResponse().getWriter().print(ObjectToJson.listToJson(list));
			GetRequestorResponse.getResponse().getWriter().print(ObjectToJson.stringToJson());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// 注销成功
	public String logout() throws Exception {
		System.out.println("5555555");
		Gson gson = new Gson();
		PrintWriter out = JsonUtil.getHeader();
		Map<String, Object> map = new HashMap<String, Object>();
		if (GetRequestorResponse.getSession().getAttribute("username") != null) {
			GetRequestorResponse.getSession().removeAttribute("username");
			map.put("code", 0);
			map.put("msg", "注销成功");
		} else {
			map.put("code", 3);
			map.put("msg", "已超时,请登录");
		}
		JSONObject object = JSONObject.fromObject(map);
		out.print(object);
		return null;
	}
}
