package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

import entity.Recruit;
import entity.User;
import net.sf.json.JSONObject;
import service.RecruitService;
import service.UserService;
import util.JsonUtil;
import util.OutContent;

public class RecruitAction extends ActionSupport {
	private Recruit recruit;
	private RecruitService recruitService;
	private UserService userService;
	private String userStatus;
	private String[] ids;
	private String id;
	private String email;
	private String name;

	Map<String, Object> res = new HashMap<String, Object>();

	public RecruitService getRecruitService() {
		return recruitService;
	}

	public void setRecruitService(RecruitService recruitService) {
		this.recruitService = recruitService;
	}

	public void setRecruit(Recruit recruit) {
		this.recruit = recruit;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public Recruit getRecruit() {
		return recruit;
	}

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String addRecruit() throws Exception {
		PrintWriter out = JsonUtil.getHeader();
		Gson gson = new Gson();
		try {
			String jsoon = JsonUtil.getStrResponse();
			System.out.println("*recruit" + jsoon);
			JSONObject jsonobject = JSONObject.fromObject(jsoon);
			Recruit recruit = (Recruit) JSONObject.toBean(jsonobject, Recruit.class);
			// Recruit recruit=new Recruit();
			// recruit.setR_id(1);
			// recruit.setName("zzu");
			// recruit.setSchool("zzuuzz");
			if (recruitService.saveRecruit(recruit))
				OutContent.successCotent(res, "发送成功，请等待审核，届时会发送至您的邮箱！");
			else {
				OutContent.failCotent(res, "请完善您的信息！");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String romoveRecruit() throws IOException {
		PrintWriter out = JsonUtil.getHeader();
		Gson gson = new Gson();
		try {
			/*
			 * String jsoon = JsonUtil.getStrResponse(); JSONObject jsonobject =
			 * JSONObject.fromObject(jsoon); Recruit user=
			 * (Recruit)JSONObject.toBean(jsonobject,Recruit.class);
			 */
			Recruit recruit = new Recruit();
			recruit.setR_id(2);
			recruit.setName("zzu");
			recruit.setSchool("zzuuzz");
			if (recruitService.deleteRecruit(recruit)) {
				ServletActionContext.getResponse().getWriter().print("{code:0}");// 删除成功
			} else {
				ServletActionContext.getResponse().getWriter().print("{code:3}");// 删除失败
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String update() throws Exception {
		if (recruitService.updateRecruit(ids, userStatus))
			OutContent.successCotent(res, "操作成功！");
		else
			OutContent.failCotent(res, "操作失败！");
		return null;
	}

	public String failed() throws Exception {

		String ids[] = { id };
		if (recruitService.updateRecruit(ids, userStatus))
			OutContent.successCotent(res, "操作成功！");
		else
			OutContent.failCotent(res, "操作失败！");
		return null;
	}

	/*
	 * public String getSize_page() { try { PrintWriter out = JsonUtil.getHeader();
	 * Gson gson = new
	 * GsonBuilder().excludeFieldsWithoutExposeAnnotation().create(); List<Recruit>
	 * list = recruitService.getAllRecruit(); List<Recruit> list1 =
	 * SeparatePage.separatePage(list.size(), GetSQLYuJu.RECRUIT_SEPERATEPAGE);
	 * res.put("code", 0); res.put("content", list1); res.put("totalCount",
	 * list.size()); JSONObject msg = JSONObject.fromObject(res); out.print(msg);
	 * out.close(); } catch (IOException e) { e.printStackTrace(); } return null; }
	 */
	public String getAllRecruit() throws Exception {
		List<Recruit> list = recruitService.getAllRecruit(userStatus);
		OutContent.content(list);
		return null;
	}

	public String pass() throws Exception {
		try {
			User user = userService.pass(email, new String(name.getBytes("iso8859-1"), "UTF-8"));
			if (recruitService.access(user))
				OutContent.active(res, "录用员工成功，请为员工分配部门！");
			else
				OutContent.failCotent(res, "您的激活码以过期！");
		} catch (Exception e) {
			OutContent.failCotent(res, "操作异常！请删除低版本的测试数据");
		}
		return null;
	}

	public String getPartRecruit() {

		return "";
	}
}
