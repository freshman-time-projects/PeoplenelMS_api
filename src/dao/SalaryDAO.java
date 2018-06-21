package dao;

import java.util.List;

import customdefinited.customdentity.EmployeeSalary;
import entity.Salary;

public interface SalaryDAO {
	public boolean saveSalary(Salary salary, String e_id);

	public Integer deleteSalary(Salary salary);

	public boolean updateSalary(Integer e_id);

	public List<Salary> getAllSalary();

	public List<Salary> getPartSalary();

	public boolean bonus(Salary salary);

	public Integer getSalary();
}
