package customdefinited.customdentity;


public class EmployeeSalary {
	@Override
	public String toString() {
		return "EmployeeSalary [e_id=" + e_id + ", username=" + username
				+ ", salary=" + salary + ", bonus=" + bonus
				+ ", departmentname=" + departmentname + "]";
	}
	//////获取员工 的信息和薪水的表格
	private Integer e_id;
	private String username;
	private String salary;
	private Double bonus;
	private String departmentname;
	public String getDepartmentname() {
		return departmentname;
	}
	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}
	public Integer getE_id() {
		return e_id;
	}
	public void setE_id(Integer e_id) {
		this.e_id = e_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public Double getBonus() {
		return bonus;
	}
	public void setBonus(Double bonus) {
		this.bonus = bonus;
	}
}
