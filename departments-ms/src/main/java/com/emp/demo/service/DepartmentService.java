package com.emp.demo.service;

import java.util.List;

import com.emp.demo.entities.Department;
import com.emp.demo.entities.Employee;

public interface DepartmentService 
{
	public Department addDepartment(Department dept);
	public Department updateDepartment(Department dept,int deptId);
	public boolean deleteDepartment(int deptId);
	public Department getDepartment(int deptId);
	public List<Employee> getEmployeesOfDepartment(int deptId);
	
	

}
