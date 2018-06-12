package sql;

public class GetSQLYuJu {
public static final String SQLEDPART = "select e.e_id,e.name,e.age,e.sex,e.marry,e.idCard,e.edu,e.school,e.mobile,e.address,e.email,d.name departmentname from employee as e,department as d where e.d_id=d.d_id";
public static final String SEPERATEPAGE = "select e.e_id,e.name,e.age,e.sex,e.marry,e.idCard,e.edu,e.school,e.mobile,e.address,e.email,d.name departmentname from employee as e,department as d limit ?,?";
public static final String LOGINCHECK = "from User as u where u.username=? and u.password=?";
public static final String GETPART = "from User as u where u.username like ? ";
public static final String RECRUITOBJECT = "from Recruit as r where r.name=? and r.r_id=?";
public static final String RECRUITPART = "from Recruit as r where r.name like ? ";
public static final String DEPARTMENTPART = "from Department as d where d.name like ?"; 
public static final String DEPARTMENTMEMBER = "from Department as d where d.name=?";
public static final String DEPARTMENTALL = "select d.d_id, d.name,d.description,d.manager from department as d";
public static final String DEPARTMENTCOUNT_EXITS=" select d.d_id,d.name,d.description,d.manager,count(e.d_id) from department as d,employee as e where d.d_id=e.d_id group by d.d_id";
public static final String DEPARTMENTCOUNT_NOT_EXITS ="select * from department where department.d_id not in (select employee.d_id from employee group by d_id)";
public static final String USER_ALL_PAGE = "select * from user limit ? ,?";
public static final String EMPLOYEE_GET_ONE = "from Employee as e where e.e_id=?";
public static final String EMPLOYEE_GET_PART ="from Employee as e where e.name=? or e.e_id=?";
}
