package service.impl;

import java.util.List;

import dao.SalaryDAO;
import entity.Salary;
import service.SalaryService;

public class SalaryServiceImpl implements SalaryService{
	private SalaryDAO salaryDAO;
	
	public SalaryDAO getSalaryDAO() {
		return salaryDAO;
	}

	public void setSalaryDAO(SalaryDAO salaryDAO) {
		this.salaryDAO = salaryDAO;
	}

	@Override
	public boolean saveSalary(Salary salary,String e_id) {
		return salaryDAO.saveSalary(salary,e_id);
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
	public Salary getSalary() {
		// TODO Auto-generated method stub
		return null;
	}

}
