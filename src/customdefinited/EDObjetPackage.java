package customdefinited;

import java.util.ArrayList;
import java.util.List;

import entity.EmployeeAndDepartment;

public class EDObjetPackage {
 public static List<EmployeeAndDepartment> getEDList(List<Object[]> list){
	 List<EmployeeAndDepartment>EDlist=new ArrayList<EmployeeAndDepartment>();
	 for(Object[] object:list){
			EmployeeAndDepartment employeeAndDepartment = new EmployeeAndDepartment();
			employeeAndDepartment.setE_id((Integer)(object[0]));
			employeeAndDepartment.setName((String)(object[1]));
			employeeAndDepartment.setAge((Integer)(object[2]));
			employeeAndDepartment.setSex((String)(object[3]));
			employeeAndDepartment.setMarry((String)(object[4]));
			employeeAndDepartment.setIdCard((String)(object[5]));
			employeeAndDepartment.setEdu((String)(object[6]));
			employeeAndDepartment.setSchool((String)(object[7]));
			employeeAndDepartment.setMobile((Integer)(object[8]));
			employeeAndDepartment.setAddress((String)(object[9]));
			employeeAndDepartment.setEamil((String)(object[10]));
			employeeAndDepartment.setDepartment((String)(object[11]));
			EDlist.add(employeeAndDepartment);
	 }
	 return EDlist;
 }
}
