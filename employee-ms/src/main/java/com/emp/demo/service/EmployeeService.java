package com.emp.demo.service;

import java.util.List;

import com.emp.demo.entities.Employee;

public interface EmployeeService 
{
	public Employee addDepartment(Employee emp);
	public Employee updateDepartment(Employee emp,int empId);
	public boolean deleteDepartment(int empId);
	public Employee getDepartment(int empId);
	public List<Employee> getEmployeesByDepartmentId(int deptId);

}
