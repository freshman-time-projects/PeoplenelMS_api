package action;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import entity.Salary;
import net.sf.json.JSONObject;
import service.SalaryService;
import util.JsonUtil;
import util.OutContent;

public class SalaryAction extends ActionSupport {
	private SalaryService salaryService;
	Map<String, Object> map = new HashMap<String, Object>();

	public SalaryService getSalaryService() {
		return salaryService;
	}

	public void setSalaryService(SalaryService salaryService) {
		this.salaryService = salaryService;
	}

	public String add() throws Exception {
		try {
			// 处理跨域
			String jsoon = JsonUtil.getStrResponse();
			/*
			 * String jsoon = "{'name':'12','description':'45',}";//**************
			 */
			JSONObject jsonObject = JSONObject.fromObject(jsoon);
			Salary salary = (Salary) JSONObject.toBean(jsonObject, Salary.class);
			if (salaryService.saveSalary(salary," ")) {
				OutContent.successCotent(map, "保存成功!");
			} else {
				OutContent.failCotent(map, "保存失败!");
			}
			/* JSONObject json = JSONObject.fromObject(map); */
		} catch (Exception e) {
			OutContent.failCotent(map, "保存失败!");
		}
		return null;
	}

	public String romoveSalary() {

		return "";
	}

	public String updateSalary() {

		return "";
	}

	public String getAllSalary() {

		return "";
	}

	public String getSalary() {

		return "";
	}

	public String getPartSalary() {

		return "";
	}
}
