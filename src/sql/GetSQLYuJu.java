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
public static final String DEPARTMENTCOUNT="select d.d_id,d.name,d.description,d.manager,count(d.name) from department as d group by d.name";
public static final String USERALLPAGE = "select * from user limit ? ,?";
}
