
/**
 *
 * User：
1. 登录：URL /user_login (post) {user}
2. 注册：URL /user_register (post) {user}
3. 删除：URL /user_romove (post) {u_id}
4. 更新：URL /user_update (post) {user}
5. 查询所有................user_getAll(get)
6. 查询部分................user_getPart (get)
7. 退出.......................user_logout  (get)
8. post放入
参数：user(u_id(int),username,password,email,role,code)
9.返回信息：
	         code:0,1,2,3
	         msg:xx 

Recruit：
1. 注册：URL /recruit_add (post) {recruit}
2. 删除：URL /recruit_romove (post) {r_id}
3. 更新：URL /recruit_update (post) {recruit}
4. 查询所有：...............recruit_getAll(get)
5. 查询单个：...............recruit_get (get)
6. 搜索：...............recruit_getPart (get)
7. post放入
参数：recruit(r_id，name，sex，school，filepath，state（int）)
8.返回信息：
         code:0
         msg:xxx
employee：
	  1. 添加：URL/employee_add (post) {employee}
	  2. 删除：URL /employee_romove (post) {e_id}
	  3. 更新：URL /employee_update (post) {employee}
      4. 查询所有：URL /employee_getAll (get) 
      5. 查询：.........employee_get (get)
      6. 查询部分：..........employee_getPart (get)
      7. post放入
                            参数：employee(e_id,name，age（int）,sex,marry,idCard,edu,school,mobile,
         address,email,department(Department),salary(Salary))
      8.返回信息：
         code:0
         msg:xxx

department：
	  1. 添加：URL /department_add (post) {department}
	  2. 删除：URL /department_romove (post) {d_id}
	  3. 更新：URL /department_update (post) {department}
      4. 查询所有：.............department_getAll (get) 
      5. 查询部分：.................department_getPart (get)
      6. 查询单个：...............department_getPart (get)
      7. post放入
                             参数： department(d_id ,name，manager，manyEmployee(Set<Employee>))
      8. 返回信息：
           code:0
           msg:xxx
EmployeeAndDepartment综合相关：
      1. 查询所有员工和部门：URL /employeeAnddepartment_getAllEmployeeAndDepartment  (get)
      2. 查询：URL /employeeAnddepartment_getSize_page  (get)
      3. post放入（暂时未用上post）
                  参数：employee(e_id,name，age（Integer）,sex,marry,idCard,edu,school,mobile,
      address,email,department)
Salary：
      1. 添加： URL /...addSalary  (post) {salary}
      2. 删除：URL /...romoveSalary  (post) {s_id}
      3. 更新： URL /...updateSalary  (post) {salary}
      4. 查询所有：URL /...updateSalary (get)
      5. 查询部分： URL /...getPartSalary (get)
      6. 查询单人：URL /...getSalary (get)
      7. post放入：
                           参数：salary(s_id,name,salary,bonus(Double),employee(Employee))
      8. 返回信息：
            code:0
            msg:xxx
 * 
**/

