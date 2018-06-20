package service.impl;

import java.util.List;

import service.SalaryService;
import customdefinited.customdentity.EmployeeSalary;
import dao.SalaryDAO;
import entity.Salary;

public class SalaryServiceImpl implements SalaryService {
	private SalaryDAO salaryDAOImpl;

	public SalaryDAO getSalaryDAOImpl() {
		return salaryDAOImpl;
	}

	public void setSalaryDAOImpl(SalaryDAO salaryDAOImpl) {
		this.salaryDAOImpl = salaryDAOImpl;
	}

	public Integer saveSalary(Salary salary) {

		return null;
	}

	@Override
	public Integer deleteSalary(Salary salary) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateSalary(Salary salary) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Salary> getAllSalary() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Salary> getPartSalary() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getSalary() {
		Integer count = salaryDAOImpl.getSalary();
		return count==null?null:count;
	}

}
