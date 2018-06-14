package entity;

import java.util.Set;

import com.google.gson.annotations.Expose;

public class Department {
	@Expose
	private Integer d_id;
	 @Expose
	private String name;
	 @Expose
	private String manager;
	 @Expose
	private String description;
	private Set<Employee> manyEmployee;
	
	public Set<Employee> getManyEmployee() {
		return manyEmployee;
	}
	public void setManyEmployee(Set<Employee> manyEmployee) {
		this.manyEmployee = manyEmployee;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
