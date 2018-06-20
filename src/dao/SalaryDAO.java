package dao;

import java.util.List;

import entity.Salary;
public interface SalaryDAO {
	public boolean saveSalary(Salary salary,String e_id);
	public Integer deleteSalary(Salary salary);
	public Integer UpdateSalary(Salary salary);
	public List<Salary> getAllSalary();
	public List<Salary> getPartSalary();
	public Salary getSalary();
}
