package util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class GetRequestorResponse extends ActionSupport{
public static HttpServletRequest getRequest (){
	return ServletActionContext.getRequest();
}
public static HttpServletResponse getResponse (){
	return ServletActionContext.getResponse();
}
public static HttpSession getSession (){
	return ServletActionContext.getRequest().getSession();
}

}
