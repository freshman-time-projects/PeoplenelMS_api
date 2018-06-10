package sql;

public class GetSQLYuJu {
public static final String SQLEDPART = "select e.e_id,e.name,e.age,e.sex,e.marry,e.idCard,e.edu,e.school,e.mobile,e.address,e.email,d.name departmentname from employee as e,department as d where e.d_id=d.d_id";
public static final String SEPERATEPAGE = "select e.e_id,e.name,e.age,e.sex,e.marry,e.idCard,e.edu,e.school,e.mobile,e.address,e.email,d.name departmentname from employee as e,department as d limit ?,?";
public static final String LOGINCHECK = "from User as u where u.username=? and u.password=?";
public static final String GETPART = "from User as u where u.username like ? ";
public static final String RECRUITOBJECT = "from Recruit as r where r.name=? and r.r_id=?";
public static final String RECRUITPART = "from Recruit as r where r.name like ? ";
}
