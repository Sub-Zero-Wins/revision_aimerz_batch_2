package com.emp.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.emp.demo.entities.Department;
import com.emp.demo.entities.Employee;
import com.emp.demo.repository.DepartmentRepository;

public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentRepository repository;
	
	@Override
	public Department addDepartment(Department dept) {
		
		return repository.save(dept);
	}

	@Override
	public Department updateDepartment(Department dept, int deptId) {
		if(repository.findById(deptId)!=null)
		{
			return repository.save(dept);
		}
		return null ;
	}

	@Override
	public boolean deleteDepartment(int deptId) {
		
		if(repository.findById(deptId)!=null)
		{
			repository.deleteById(deptId);
			return true;
		}
		return false;
	}

	@Override
	public Department getDepartment(int deptId) {
		
		return repository.findById(deptId).get();
	}

	@Override
	public List<Employee> getEmployeesOfDepartment(int deptId) {
		// TODO Auto-generated method stub
		return null;
	}

}
