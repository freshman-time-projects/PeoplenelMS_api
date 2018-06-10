package util;

import java.io.PrintWriter;
import java.util.List;

import net.sf.json.JSONArray;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate5.HibernateTemplate;

import sql.GetSQLYuJu;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;

import customdefinited.EDObjetPackage;
import entity.EmployeeAndDepartment;

public class SeparatePage extends ActionSupport{
	private static SessionFactory sessionFactory;
	private static HibernateTemplate hibernateTemplate;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	public static List<EmployeeAndDepartment> separatePage(int totalCount){
		try {
//			JSONObject jsonObject = JsonReader.receivePost(GetRequestorResponse.getRequest());
			Integer current = Integer.parseInt(GetRequestorResponse.getRequest().getParameter("current")==null?"1":GetRequestorResponse.getRequest().getParameter("current"));
			Integer pageSize =  Integer.parseInt(GetRequestorResponse.getRequest().getParameter("size")==null?"4":GetRequestorResponse.getRequest().getParameter("size"));
			System.out.println(current+"**************"+totalCount);
			if(current==0||current==null)
				current=1;
			if(pageSize==0||pageSize==null)
				pageSize=10;
			int maxValue=pageSize*current;
			if(maxValue>totalCount){
				maxValue=totalCount;
			}
			//sql分頁
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			List<Object[]> list = session.createSQLQuery(GetSQLYuJu.SEPERATEPAGE)
					.setParameter(0,maxValue%pageSize==0?(maxValue-pageSize):(maxValue-maxValue%pageSize))
					.setParameter(1,maxValue%pageSize==0?pageSize:(maxValue%pageSize))
					.list();
			List<EmployeeAndDepartment> employeeList = EDObjetPackage.getEDList(list);
			PrintWriter out=null;
		/*	out = JsonUtil.getHeader();
			Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
			JSONArray msg = JSONArray.fromObject(employeeList);*/
			return employeeList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
