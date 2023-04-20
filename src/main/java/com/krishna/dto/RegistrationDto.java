package com.krishna.dto;

public class RegistrationDto {
	
	private int id = 1032;
	private String userName;
	private String role;
	private String dept;
	private String email;
	private String password;
	private String mobile;
	
	public RegistrationDto(int id, String userName, String role, String dept, String email, String password,
			String mobile) {
		super();
		this.id = id;
		this.userName = userName;
		this.role = role;
		this.dept = dept;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "RegistrationDto [id=" + id + ", userName=" + userName + ", role=" + role + ", dept=" + dept + ", email="
				+ email + ", password=" + password + ", mobile=" + mobile + "]";
	}
	public RegistrationDto() {
		super();
	}
	
	
	
	
	
	
	
	

}
