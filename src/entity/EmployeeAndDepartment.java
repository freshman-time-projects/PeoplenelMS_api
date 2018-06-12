package entity;

import com.google.gson.annotations.Expose;

public class EmployeeAndDepartment {
	@Expose
	private Integer e_id;
	 @Expose
	private String name;
	 @Expose
	private Integer age;
	 @Expose
	private String sex;
	 @Expose
	private String marry;
	 @Expose
	private String idCard;
	 @Expose
	private String edu;
	 @Expose
	private String school;
	 @Expose
	private String mobile;
	 @Expose
	private String address;
	 @Expose
	private String email;
	 @Expose
	private String department;// 一对多的部门
	 public Integer getE_id() {
		return e_id;
	}
	public void setE_id(Integer e_id) {
		this.e_id = e_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getMarry() {
		return marry;
	}
	public void setMarry(String marry) {
		this.marry = marry;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getEdu() {
		return edu;
	}
	public void setEdu(String edu) {
		this.edu = edu;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
}
