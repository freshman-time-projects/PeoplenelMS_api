package sql;

public class GetSQLYuJu {
public static final String SQLEDPART = "select e.e_id,e.name,e.age,e.sex,e.marry,e.idCard,e.edu,e.school,e.mobile,e.address,e.email,d.name departmentname,e.d_id from employee as e,department as d where e.d_id=d.d_id";
public static final String SEPERATEPAGE = "select e.e_id,e.name,e.age,e.sex,e.marry,e.idCard,e.edu,e.school,e.mobile,e.address,e.email,d.name departmentname,e.d_id from employee as e,department as d where d.d_id=e.d_id limit ?,?";
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
public static final String EMPLOYEE_UPDATE_ONE = "update employee set age =44 where e_id = 25;";
public static final String EMPLOYEE_GET_ONE = "select e.e_id,e.name,e.age,e.sex,e.marry,e.idCard,e.edu,e.school,e.mobile,e.address,e.email,d.name departmentname,e.d_id from employee as e,department as d where e.e_id=?";
public static final String EMPLOYEE_GET_PART ="select e.e_id,e.name,e.age,e.sex,e.marry,e.idCard,e.edu,e.school,e.mobile,e.address,e.email,d.name departmentname,e.d_id from employee as e left join department as d on e.d_id=d.d_id where e.name like ? or d.description like ?";
public static final String EMPLOYEE_GET_DEPARTMENT = "select d.d_id,d.name,d.description,d.manager from department as d where d.name=?";
//**********利用级联删除时,只需要删除员工即可,数据库会根据级联自动删除有关联的salary**********************/
public static final String EMPLOYEE_DELETE_ONE ="from Employee as e where e.e_id=?";
public static final String SALARY_SEARCH =  "select e.name,s.salary,s.bonus,s.e_id,d.name departmentname from (department as d inner join employee as e on d.d_id=e.d_id) inner join salary as s on s.e_id=e.e_id";
public static final String SALARY_SEARCH_PAGE = "select e.name,s.salary,s.bonus,s.e_id,d.name departmentname from (department as d inner join employee as e on d.d_id=e.d_id) inner join salary as s on s.e_id=e.e_id limit ?,?";
}
