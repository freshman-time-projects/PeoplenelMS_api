package sql;

public class GetSQLYuJu {
	public static final String SQLEDPART = "select e.e_id,e.name,e.age,e.sex,e.marry,e.idCard,e.edu,e.school,e.mobile,e.address,e.email,d.name departmentname,e.d_id from employee as e,department as d where e.d_id=d.d_id";
	public static final String SEPERATEPAGE = "select e.e_id,e.name,e.age,e.sex,e.marry,e.idCard,e.edu,e.school,e.mobile,e.address,e.email,d.name departmentname,e.d_id from employee as e,department as d where d.d_id=e.d_id limit ?,?";
	public static final String RECRUIT_SEPERATEPAGE = "select name,sex,school,filepath from recruit limit ?,?";
	public static final String LOGINCHECK = "from User as u where (u.username=? or u.email=?) and u.password=?";
	public static final String GETPART = "from User as u where u.username like ? ";
	public static final String RECRUITOBJECT = "from Recruit as r where r.name=? and r.r_id=?";
	public static final String RECRUITPART = "from Recruit as r where r.name like ? ";
	public static final String RECRUITPART_ALL = "from Recruit where state = ?";
	public static final String RECRUITPART_ALL_COUNTABLE = "from Recruit where state != 2";
	public static final String DEPARTMENTPART = "from Department as d where d.name like ?";
	public static final String DEPARTMENTMEMBER = "from Department as d where d.name=?";
	public static final String DEPARTMENTALL = "select d.d_id, d.name,d.description,d.manager from department as d";
	public static final String DEPARTMENTCOUNT_EXITS = " select d.d_id,d.name,d.description,d.manager,count(e.d_id) from department as d,employee as e where d.d_id=e.d_id group by d.d_id";
	public static final String DEPARTMENTCOUNT_NOT_EXITS = "select * from department where department.d_id not in (select employee.d_id from employee group by d_id)";
	public static final String USER_ALL_PAGE = "select * from user limit ? ,?";
	public static final String EMPLOYEE_UPDATE_ONE = "update employee set age =44 where e_id = 25;";
	public static final String EMPLOYEE_GET_ONE = "select e.e_id,e.name,e.age,e.sex,e.marry,e.idCard,e.edu,e.school,e.mobile,e.address,e.email,d.name departmentname,e.d_id from employee as e,department as d where e.e_id=? or e.email=?";
	public static final String EMPLOYEE_GET_PART = "select e.e_id,e.name,e.age,e.sex,e.marry,e.idCard,e.edu,e.school,e.mobile,e.address,e.email,d.name departmentname from employee as e,department as d where (e.d_id = d.d_id) and (e.name like '%aa%' or e.age like '%aa%')";
	public static final String EMPLOYEE_GET_DEPARTMENT = "select d.d_id,d.name,d.description,d.manager from department as d where d.name=?";
	public static final String SALARY_GET_EMPLOYEE = "select e.e_id,e.name from employee as e where e.email=?";
	// **********利用级联删除时,只需要删除员工即可,数据库会根据级联自动删除有关联的salary**********************/
	public static final String EMPLOYEE_DELETE_ONE = "from Employee where e_id=?"; // 修改 sql 语句 不能使用 as
	public static final String USER_FIND_BYNAME = "from User where code = ?";
	public static final String RECRUIT_UPDATE_MUL = "update recruit set state = ? where r_id in (:ids)";
	public static final String RECRUIT_PASS = "from User where account = ? and email = ?";
	public static final String RECRUIT_PASS_EMAIL = "from Recruit where name=? and email = ?";

}
