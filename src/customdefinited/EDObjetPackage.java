package customdefinited;

import java.util.ArrayList;
import java.util.List;

import customdefinited.customdentity.CustomDepartment;
import entity.Department;
import entity.EmployeeAndDepartment;
import entity.User;

public class EDObjetPackage {
	public static List<EmployeeAndDepartment> getEDList(List<Object[]> list) {
		List<EmployeeAndDepartment> EDlist = new ArrayList<EmployeeAndDepartment>();
		for (Object[] object : list) {
			EmployeeAndDepartment employeeAndDepartment = new EmployeeAndDepartment();
			employeeAndDepartment.setE_id((Integer) (object[0]));
			employeeAndDepartment.setName((String) (object[1]));
			employeeAndDepartment.setAge((Integer) (object[2]));
			employeeAndDepartment.setSex((String) (object[3]));
			employeeAndDepartment.setMarry((String) (object[4]));
			employeeAndDepartment.setIdCard((String) (object[5]));
			employeeAndDepartment.setEdu((String) (object[6]));
			employeeAndDepartment.setSchool((String) (object[7]));
			employeeAndDepartment.setMobile((Integer) (object[8]));
			employeeAndDepartment.setAddress((String) (object[9]));
			employeeAndDepartment.setEamil((String) (object[10]));
			employeeAndDepartment.setDepartment((String) (object[11]));
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
			customDepartment.setSumpeople((String) object[4].toString());
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
	
	
}
