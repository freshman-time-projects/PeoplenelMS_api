package service;

import java.util.List;

import entity.Salary;
import entity.User;

public interface SalaryService {
	public Integer saveSalary();
	public Integer deleteSalary();
	public Integer updateSalary();
	public List<Salary> getAllSalary();
	public List<Salary> getPartSalary();
	public Salary getSalary();
}
