package dao;

import java.util.List;

import entity.Salary;
public interface SalaryDAO {
	public boolean bonus(Salary salary);
	public Salary getSalary();
}
