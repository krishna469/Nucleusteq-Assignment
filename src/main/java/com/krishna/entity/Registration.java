package com.krishna.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

@Entity
@SequenceGenerator(name = "seq", initialValue = 1010, allocationSize = 1)
public class Registration {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	private int id;
	
	@Column(nullable = false)
	private String userName;
	
	@Column(nullable = false)
	private String gender;
	
	@Column(nullable = false)
	private String role;
	
	@Column(nullable = false)
	private String dept;
	
	@Column(nullable = false, unique = true)
	@Email
	private String email;
	
	@Column(nullable = false)
	//@Size(min = 4, max = 10, message = "Password length must be between 4 and 10 characters")
	private String password;
	
	@Column(nullable = false, unique = true)
	@Size(min = 10, max = 10, message = "Mobile Number must be 10 digit")
	private String mobile;
	
	
	public Registration( String userName,String gender, String role, String dept, String email, String password,
			String mobile) {
		super();
		this.userName = userName;
		this.gender=gender;
		this.role = role;
		this.dept = dept;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
	}


	public Registration() {
		super();
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
		return "Rgistration [id=" + id + ", userName=" + userName + ", role=" + role + ", dept=" + dept + ", email="
				+ email + ", password=" + password + ", mobile=" + mobile + "]";
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
	
	
	
	
	
	
}
