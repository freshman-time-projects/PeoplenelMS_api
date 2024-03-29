package customdefinited;

import java.util.ArrayList;
import java.util.List;

import customdefinited.customdentity.CustomDepartment;
import customdefinited.customdentity.EmployeeSalary;
import entity.Department;
import entity.Employee;
import entity.EmployeeAndDepartment;
import entity.User;

public class ToVirtualEntity {
	public static List<EmployeeAndDepartment> getEDList(List<Object[]> list) {
		List<EmployeeAndDepartment> EDlist = new ArrayList<EmployeeAndDepartment>();
		for (Object[] object : list) {
			System.out.println(object.length+"88888888888888888888888888888888888888888888888888888++++++++");
			EmployeeAndDepartment employeeAndDepartment = new EmployeeAndDepartment();
			employeeAndDepartment.setE_id((Integer) (object[0]));
			employeeAndDepartment.setName((String) (object[1]));
			employeeAndDepartment.setAge((Integer) (object[2]));
			employeeAndDepartment.setSex((String) (object[3]));
			employeeAndDepartment.setMarry((String) (object[4]));
			employeeAndDepartment.setIdCard((String) (object[5]));
			employeeAndDepartment.setEdu((String) (object[6]));
			employeeAndDepartment.setSchool((String) (object[7]));
			employeeAndDepartment.setMobile((String) (object[8]));
			employeeAndDepartment.setAddress((String) (object[9]));
			employeeAndDepartment.setEmail((String) (object[10]));
			employeeAndDepartment.setDepartment((String) (object[11]));
			employeeAndDepartment.setD_id((Integer)(object[12]));
			EDlist.add(employeeAndDepartment);
		}
		return EDlist;
	}

	public static List<Department> getDList(List<Object[]> list) {
		List<Department> Dlist = new ArrayList<Department>();
		for (Object[] object : list) {
			Department department = new Department();
			department.setD_id((Integer)object[0]);
			department.setName((String) object[1]);
			department.setDescription((String) object[2]);
			department.setManager((String) object[3]);
			Dlist.add(department);
		}
		return Dlist;
	}
	//******************************自定义转entity 
	public static List<CustomDepartment> getCustomDepartment(List<Object[]> list1,List<Object[]> list2) {
		List<CustomDepartment> CDlist = new ArrayList<CustomDepartment>();
		for (Object[] object : list1) {
			CustomDepartment customDepartment = new CustomDepartment();
			customDepartment.setD_id((Integer)object[0]);
			customDepartment.setName((String) object[1]);
			customDepartment.setDescription(((String) object[2]));
			customDepartment.setManager((String) object[3]);
			System.out.println("8888888888"+object[4].toString().getClass());
			customDepartment.setSumpeople(object[4].toString());
			CDlist.add(customDepartment);
		}
		for (Object[] object : list2) {
			CustomDepartment customDepartment = new CustomDepartment();
			customDepartment.setD_id((Integer)object[0]);
			customDepartment.setName((String) object[1]);
			customDepartment.setDescription(((String) object[2]));
			customDepartment.setManager((String) object[3]);
			customDepartment.setSumpeople("0");
			CDlist.add(customDepartment);
		}
		return CDlist;
	}
	
	public static List<User> getUser(List<Object[]> list) {
		List<User> userList = new ArrayList<User>();
		for (Object[] object : list) {
			User user = new User();
			user.setU_id((Integer)object[0]);
			user.setUsername((String) object[1]);
			user.setPassword(((String) object[2]));
			user.setEmail((String) object[3]);
			user.setRole((String) object[4]);
			user.setCode((String)object[5]);
			userList.add(user);
		}
		return userList;
	}
/*	public static List<Recruit> getRecruit(List<Object[]> list) {
		List<User> recruitList = new ArrayList<User>();
		for (Object[] object : list) {
			Recruit recruit = new Recruit();
			recruit.setUsername((String) object[1]);
			recruitList.add(recruit);
		}
		return userList;
	}*/
	
	public static Department getDepartment(List<Object[]> list) {
		Department department = new Department();
		for (Object[] object : list) {
			department.setD_id((Integer)object[0]);
			department.setName(object[0].toString());
			department.setDescription(object[1].toString());
			department.setManager(object[2].toString());
		}
		return department;
	}
	public static Employee getEmployee(List<Object[]> list) {
		Employee employee = new Employee();
		for (Object[] object : list) {
			employee.setE_id((Integer)object[0]);
			employee.setName(object[1].toString());
		}
		return employee;
	}
	//设置Object组合转换成EmployeeSalary类型
	public static List<EmployeeSalary> getEmployeeSalary(List<Object[]> list) {
		List<EmployeeSalary> mployeeSalary = new ArrayList<EmployeeSalary>();
		for (Object[] object : list) {
			EmployeeSalary employeeSalary = new EmployeeSalary();
			employeeSalary.setS_id((Integer)object[0]);
			employeeSalary.setUsername((String)object[1]);
			employeeSalary.setSalary(((String) object[2]));
			employeeSalary.setBonus((Double) object[3]);
			employeeSalary.setE_id((Integer) object[4]);
			employeeSalary.setDepartmentname((String)object[5]);
			mployeeSalary.add(employeeSalary);
		}
		return mployeeSalary;
	}
	
	
}
