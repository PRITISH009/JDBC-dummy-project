package com.company.eis.bean;

public class Employee {
	
	private String userId;
	private String name;
	private int salary;
	private String designation;
	
	public Employee(String userId, String name, int salary, String designation) {
		super();
		this.userId = userId;
		this.name = name;
		this.salary = salary;
		this.designation = designation;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String id) {
		this.userId = id;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	
}
