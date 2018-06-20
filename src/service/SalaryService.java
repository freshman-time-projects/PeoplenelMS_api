package service;

import java.util.List;

import customdefinited.customdentity.EmployeeSalary;
import entity.Salary;
import entity.User;

public interface SalaryService {
	public Integer saveSalary(Salary salary);
	public Integer deleteSalary(Salary salary);
	public Integer updateSalary(Salary salary);
	public List<Salary> getAllSalary();
	public List<Salary> getPartSalary();
	public Integer getSalary();
}
