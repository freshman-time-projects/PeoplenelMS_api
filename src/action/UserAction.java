package action;

import service.UserService;
import service.impl.UserServiceImpl;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	private UserService userService;
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String addUser() {
		System.out.println(userService);
		userService.saveUser();
		return "";
	}

	public String romoveUser() {

		return "";
	}

	public String updateUser() {

		return "";
	}

	public String getAllUser() {

		return "";
	}

	public String getUser() {

		return "";
	}

	public String getPartUser() {

		return "";
	}
}
