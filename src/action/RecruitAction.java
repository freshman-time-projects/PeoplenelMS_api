package action;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.struts2.ServletActionContext;

import service.RecruitService;
import util.JsonUtil;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

import entity.Recruit;
public class RecruitAction extends ActionSupport {
	private RecruitService recruitService;

	public RecruitService getRecruitService() {
		return recruitService;
	}

	public void setRecruitService(RecruitService recruitService) {
		this.recruitService = recruitService;
	}

	public String addRecruit() throws IOException {
		PrintWriter out = JsonUtil.getHeader();
		Gson gson = new Gson();
		try {
			/*String jsoon = JsonUtil.getStrResponse();
			JSONObject jsonobject = JSONObject.fromObject(jsoon);
			Recruit user=  (Recruit)JSONObject.toBean(jsonobject,Recruit.class);*/
			Recruit recruit=new Recruit();
			recruit.setR_id(1);
			recruit.setName("zzu");
			recruit.setSchool("zzuuzz");
			if(recruitService.saveRecruit(recruit))
             ServletActionContext.getResponse().getWriter().print("{code:0}");//有疑问待商量	保存成功		
			 ServletActionContext.getResponse().getWriter().print("{code:3}");//保存失败
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String romoveRecruit() throws IOException {
		PrintWriter out = JsonUtil.getHeader();
		Gson gson = new Gson();
		try {
			/*String jsoon = JsonUtil.getStrResponse();
			JSONObject jsonobject = JSONObject.fromObject(jsoon);
			Recruit user=  (Recruit)JSONObject.toBean(jsonobject,Recruit.class);*/
			Recruit recruit=new Recruit();
			recruit.setR_id(2);
			recruit.setName("zzu");
			recruit.setSchool("zzuuzz");
			if(recruitService.deleteRecruit(recruit)){
             ServletActionContext.getResponse().getWriter().print("{code:0}");//删除成功
			}else{
			 ServletActionContext.getResponse().getWriter().print("{code:3}");//删除失败
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String updateRecruit() {

		return "";
	}

	public String getAllRecruit() {

		return "";
	}

	public String getRecruit() {

		return "";
	}

	public String getPartRecruit() {

		return "";
	}
}
