package customdefinited.customdentity;

import com.google.gson.annotations.Expose;

public class CustomDepartment {
	private Integer d_id;
	 
	private String name;
	 
	private String manager;
	 
	private String description;
	 @Expose
	 private String sumpeople;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSumpeople() {
		return sumpeople;
	}
	public void setSumpeople(String sumpeople) {
		this.sumpeople = sumpeople;
	}
}
