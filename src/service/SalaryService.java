package service;

import java.util.List;

import entity.Salary;

public interface SalaryService {
	public boolean saveSalary(Salary salary,String e_id);
	public Integer deleteSalary(Salary salary);
	public Integer updateSalary(Salary salary);
	public List<Salary> getAllSalary();
	public List<Salary> getPartSalary();
	public Salary getSalary();
}
