package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONObject;
import service.UserService;
import util.GetRequestorResponse;
import util.JsonUtil;
import util.ObjectToJson;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import entity.User;

public class UserAction extends ActionSupport {
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
 ///测试成功
	public String login() {
		HttpSession session = GetRequestorResponse.getSession();
		HttpServletRequest request = GetRequestorResponse.getRequest();
		try {
			// 处理跨域
			PrintWriter out = JsonUtil.getHeader();
			/*String jsoon = "{" + JsonUtil.getStrResponse() + "}";
			JSONObject jsonObject = JSONObject.fromObject(jsoon);
			User user = (User) JSONObject.toBean(jsonObject, User.class);*/
			User user = new User();
			user.setUsername("xiao");
			user.setPassword("ww");
			// 判断是否登录，登录返回1，相反返回0
			int flag = userService.login(user);
			Gson gson = new Gson();
			Map<String, Object> res = new HashMap<String, Object>();
			// Gson 传输数据、
			if (flag > 0&& request.getSession().getAttribute("username") != null) {
				res.put("code", 2);
				res.put("msg", "您已登录，请不要重复登录");
				flag = -1;
			}
			if (flag > 0) {
				ActionContext.getContext().getSession().put("username", user.getUsername());
				res.put("code", 0);
				res.put("msg", "欢迎回来");
			}
			if (flag == 0) {
				res.put("code", 1);
				res.put("msg", "登录失败，用户名或密码错误");
			}
			String msg = gson.toJson(res);
			out.print(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String add() {
		try {
			String jsoon = "{" + JsonUtil.getStrResponse() + "}";
			JSONObject jsonobject = JSONObject.fromObject(jsoon);
			User user=  (User)JSONObject.toBean(jsonobject,User.class);
			if(userService.saveUser(user))
             ServletActionContext.getResponse().getWriter().print("{code:0}");//有疑问待商量	保存成功		
			 ServletActionContext.getResponse().getWriter().print("{code:3}");//保存失败
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String romove() {
		try {
			String jsoon = "{" + JsonUtil.getStrResponse() + "}";
			JSONObject jsonobject = JSONObject.fromObject(jsoon);
			User user=  (User)JSONObject.toBean(jsonobject,User.class);
			if(userService.deleteUser(user))
             ServletActionContext.getResponse().getWriter().print("{code:0}");//有疑问待商量	保存成功		
			 ServletActionContext.getResponse().getWriter().print("{code:3}");//保存失败
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String update() {
		try {
			String jsoon = "{" + JsonUtil.getStrResponse() + "}";
			JSONObject jsonobject = JSONObject.fromObject(jsoon);
			User user=  (User)JSONObject.toBean(jsonobject,User.class);
			if(userService.updateUser(user))
             ServletActionContext.getResponse().getWriter().print("{code:0}");//有疑问待商量	保存成功		
			 ServletActionContext.getResponse().getWriter().print("{code:3}");//保存失败
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getAll() {
		List<User> list = userService.getAllUser();
		try {
			PrintWriter out = JsonUtil.getHeader();
			Gson gson = new Gson();
			String msg = gson.toJson(list);
			out.println(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String get() {

		return "";
	}

	public String getPartUser() {
		try {
			String jsoon = "{" + JsonUtil.getStrResponse() + "}";
			JSONObject jsonobject = JSONObject.fromObject(jsoon);
			String data = jsonobject.getString("data");
			List<User> list = userService.getPartUser(data);
			if(list!=null)
		    GetRequestorResponse.getResponse().getWriter().print(ObjectToJson.listToJson(list));	
			GetRequestorResponse.getResponse().getWriter().print(ObjectToJson.stringToJson());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
