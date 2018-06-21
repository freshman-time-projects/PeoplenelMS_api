package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

import customdefinited.customdentity.EmployeeSalary;
import net.sf.json.JSONObject;
import service.SalaryService;
import sql.GetSQLYuJu;
import util.JsonUtil;
import util.OutContent;
import util.SeparatePage;

public class SalaryAction extends ActionSupport {
	private SalaryService salaryService;
	private Integer s_id;

	public Integer getS_id() {
		return s_id;
	}

	public void setS_id(Integer s_id) {
		this.s_id = s_id;
	}

	public SalaryService getSalaryService() {
		return salaryService;
	}

	public void setSalaryService(SalaryService salaryService) {
		this.salaryService = salaryService;
	}

	public String update() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		if (salaryService.updateSalary(s_id))
			OutContent.successCotent(map, "操作成功!");
		else
			OutContent.failCotent(map, "保存失败!");
		return null;
	}

	public String getSalary() {
		Integer listCount = salaryService.getSalary();
		List<EmployeeSalary> list = SeparatePage.ESSeparatePage(listCount, GetSQLYuJu.SALARY_SEARCH_PAGE);
		Map<String, Object> res = new HashMap<String, Object>();
		try {
			PrintWriter out = JsonUtil.getHeader();
			Gson gson = new Gson();
			if (list == null) {
				res.put("code", 0);
				res.put("content", "无数据");
				String data = gson.toJson(res);
				out.print(data);
			} else {
				res.put("code", 0);
				res.put("content", list);
				res.put("salaryCount", listCount);
				String data = gson.toJson(res);
				out.print(data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
