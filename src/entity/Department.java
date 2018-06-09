package entity;

import java.util.Set;

public class Department {
	private Integer d_id;
	private String name;
	private String manager;
	private Set<Employee> manyEmployee;
	
	public Set<Employee> getManyEmployee() {
		return manyEmployee;
	}
	public void setManyEmployee(Set<Employee> manyEmployee) {
		this.manyEmployee = manyEmployee;
	}
	public Integer getD_id() {
		return d_id;
	}
	public void setD_id(Integer d_id) {
		this.d_id = d_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}

	

}
