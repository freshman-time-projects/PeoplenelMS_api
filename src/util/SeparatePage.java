package util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import net.sf.json.JSONObject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate5.HibernateTemplate;

import sql.GetSQLYuJu;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;

import entity.EmployeeAndDepartment;

public class SeparatePage extends ActionSupport{
	private SessionFactory sessionFactory;
	private HibernateTemplate hibernateTemplate;
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
	public void separatePage(){
		try {
			JSONObject jsonObject = JsonReader.receivePost(GetRequestorResponse.getRequest());
			Integer current = (Integer)jsonObject.get("current");
			Integer pageSize = (Integer)jsonObject.get("size");
			Integer totalCount = (Integer)jsonObject.get("totalCount");
			if(current==0)
				current=1;
			int maxValue=pageSize*current;
			if(maxValue>totalCount){
				maxValue=totalCount;
			}
				
			//sql分頁
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			List<EmployeeAndDepartment> list = session.createSQLQuery(GetSQLYuJu.SEPERATEPAGE)
					.addEntity(EmployeeAndDepartment.class)
					.setParameter(1,maxValue-pageSize+1)
					.setParameter(2,maxValue)
					.list();
			PrintWriter out=null;
			out = JsonUtil.getHeader();
			Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
			String msg = gson.toJson(list);
			out.print(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
