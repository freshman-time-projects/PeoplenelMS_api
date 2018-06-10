package interfilter;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import util.JsonUtil;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class Logincheck extends MethodFilterInterceptor{
	protected String doIntercept(ActionInvocation invoke) throws Exception{
    HttpSession session =  ServletActionContext.getRequest().getSession();
    HttpServletResponse response = ServletActionContext.getResponse();
    String user = (String)session.getAttribute("username");
		if(user==null||user==""){
			Map<String,Object>map = new HashMap<String,Object>();
			map.put("code",1);
			map.put("msg","请登录");
			Gson gson = new Gson();
			String name= gson.toJson(map);
			JsonUtil.getHeader().print(name);
			return null;
		}
		return invoke.invoke();
	}
}
