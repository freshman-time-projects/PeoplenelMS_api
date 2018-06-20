package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import service.SalaryService;
import sql.GetSQLYuJu;
import util.JsonUtil;
import util.SeparatePage;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

import customdefinited.customdentity.EmployeeSalary;

public class SalaryAction extends ActionSupport {
	private SalaryService salaryService;
	public SalaryService getSalaryService() {
		return salaryService;
	}

	public void setSalaryService(SalaryService salaryService) {
		this.salaryService = salaryService;
	}

	public String update() {

		return "";
	}

	public String getSalary() {
		Integer listCount = salaryService.getSalary();
		List<EmployeeSalary> list = SeparatePage.ESSeparatePage(listCount,GetSQLYuJu.SALARY_SEARCH_PAGE);
		Map<String,Object>res = new HashMap<String,Object>();
		try {
			PrintWriter out = JsonUtil.getHeader();
			Gson gson = new Gson();
			if(list==null){
				res.put("code", 0);
				res.put("content","无数据");
				String data = gson.toJson(res);
				out.print(data);
			}else{
			res.put("code", 0);
			res.put("content",list);
			String data = gson.toJson(res);
			out.print(data);}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
