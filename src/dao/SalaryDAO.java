package dao;

import java.util.List;

import entity.Salary;
public interface SalaryDAO {
	public void saveSalary();
	public Integer deleteSalary();
	public Integer UpdateSalary();
	public List<Salary> getAllSalary();
	public List<Salary> getPartSalary();
	public Salary getSalary();
}
