package dao;

import java.util.List;

import customdefinited.customdentity.EmployeeSalary;
import entity.Salary;
public interface SalaryDAO {
	public boolean bonus(Salary salary);
	public Integer getSalary();
}
