package entity;

public class Salary {
private Integer s_id;
private String name;
private String salary;
private Double bonus;
private Employee employee;
public Employee getEmployee() {
	return employee;
}
public void setEmployee(Employee employee) {
	this.employee = employee;
}
public Integer getS_id() {
	return s_id;
}
public void setS_id(Integer s_id) {
	this.s_id = s_id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
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
