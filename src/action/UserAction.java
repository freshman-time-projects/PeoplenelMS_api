package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import service.UserService;
import util.JsonUtil;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import entity.User;

public class UserAction extends ActionSupport{
	private UserService userService;
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
    public String login(){
    	HttpSession session = ServletActionContext.getRequest().getSession();
    	HttpServletRequest request = ServletActionContext.getRequest();
    	PrintWriter out=null;
		try {
			out = JsonUtil.getHeader();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	//从前端或得一个字符串
    	String jsoon = JsonUtil.getStrResponse();
		JSONObject jsonObject = JSONObject.fromObject(jsoon);
		User userjson = (User) JSONObject.toBean(jsonObject, User.class);
		User user = new User();
		user.setUsername(userjson.getUsername());
		user.setPasword(userjson.getPasword());
		int flag = userService.login(user);
		// JSONObject jsoon=JsonReader.receivePost(request);

		// JSONObject user = JSONObject.fromObject(jsoon);
		System.out.println(userjson.toString());
		Gson gson = new Gson();
		Map<String,Object> res = new HashMap<String,Object>();
		// Gson 传输数据、
		System.out.println("&*" + request.getSession().getAttribute("username"));
		if (flag > 0 && request.getSession().getAttribute("username") != null) {
			
			res.put("code", 2);
			res.put("msg", "您已登录，请不要重复登录");
			flag = -1;
		}
		if (flag > 0) {
			ActionContext.getContext().getSession().put("username", user.getUsername());
			// request.getSession().setAttribute("username", user.getUsername());
			System.out.println("request:" + request.getSession().getAttribute("username"));
			System.out.println("context:" + ActionContext.getContext().getSession().get("username"));
			res.put("code", 0);
			res.put("msg", "欢迎回来");
		}
		if (flag == 0) {
			res.put("code", 1);
			res.put("msg", "登录失败，用户名或密码错误");
		}
		String msg = gson.toJson(res);
		out.print(msg);
    	return "success";
    }
	
	public String add() {
		System.out.println(userService);
		userService.saveUser(new User());
		return "";
	}

	public String romove() {

		return "";
	}

	public String update() {

		return "";
	}

	public String getAll() {
	 List<User> list = userService.getAllUser();
	 try {
	  PrintWriter out = JsonUtil.getHeader();
		Gson gson = new Gson();
		String msg = gson.toJson(list);
		out.println(msg);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return null;
	}

	public String get() {

		return "";
	}

	public String getPartUser() {

		return "";
	}
}
