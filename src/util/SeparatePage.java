package util;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;

import customdefinited.EDObjetPackage;
import entity.EmployeeAndDepartment;
import entity.User;

public class SeparatePage extends ActionSupport{
	private static SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public static List<EmployeeAndDepartment> separatePage(int totalCount,String sql){
		try {
//			JSONObject jsonObject = JsonReader.receivePost(GetRequestorResponse.getRequest());
			Integer current = Integer.parseInt(GetRequestorResponse.getRequest().getParameter("current")==null?"1":GetRequestorResponse.getRequest().getParameter("current"));
			Integer pageSize =  Integer.parseInt(GetRequestorResponse.getRequest().getParameter("size")==null?"10":GetRequestorResponse.getRequest().getParameter("size"));
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
			List<Object[]> list = session.createSQLQuery(sql)
					.setParameter(0,maxValue%pageSize==0?(maxValue-pageSize):(maxValue-maxValue%pageSize))
					.setParameter(1,maxValue%pageSize==0?pageSize:(maxValue%pageSize))
					.list();
			transaction.commit();
			session.close();
			List<EmployeeAndDepartment> employeeList = EDObjetPackage.getEDList(list);
			return employeeList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static List<User> ueerSeparatePage(int totalCount,String sql){
		try {
//			JSONObject jsonObject = JsonReader.receivePost(GetRequestorResponse.getRequest());
			Integer current = Integer.parseInt(GetRequestorResponse.getRequest().getParameter("current")==null?"1":GetRequestorResponse.getRequest().getParameter("current"));
			Integer pageSize =  Integer.parseInt(GetRequestorResponse.getRequest().getParameter("size")==null?"10":GetRequestorResponse.getRequest().getParameter("size"));
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
			List<Object[]> list = session.createSQLQuery(sql)
					.setParameter(0,maxValue%pageSize==0?(maxValue-pageSize):(maxValue-maxValue%pageSize))
					.setParameter(1,maxValue%pageSize==0?pageSize:(maxValue%pageSize))
					.list();
			transaction.commit();
			session.close();
			List<User> userList = EDObjetPackage.getUser(list);
			return userList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
