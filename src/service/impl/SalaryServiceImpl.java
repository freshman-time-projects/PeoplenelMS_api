package service.impl;

import java.util.List;

import dao.SalaryDAO;
import entity.Salary;
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

	public void setSalaryDAO(SalaryDAO salaryDAO) {
		this.salaryDAOImpl = salaryDAO;
	}

	@Override
	public boolean saveSalary(Salary salary, String e_id) {
		return salaryDAOImpl.saveSalary(salary, e_id);
	}

	@Override
	public Integer deleteSalary(Salary salary) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateSalary(Integer e_id) {
		if (salaryDAOImpl.updateSalary(e_id))
			return true;
		return false;
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
		return count == null ? null : count;
	}

}
