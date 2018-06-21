package service;

import java.util.List;

import customdefinited.customdentity.EmployeeSalary;
import entity.Salary;

public interface SalaryService {
	public boolean saveSalary(Salary salary, String e_id);

	public Integer deleteSalary(Salary salary);

	public List<Salary> getAllSalary();

	public List<Salary> getPartSalary();

	public Integer getSalary();

	boolean updateSalary(Integer e_id);

}
