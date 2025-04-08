package com.emp.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.demo.entities.Employee;

public interface EmployeeRepository  extends JpaRepository <Employee,Integer>
{

	
}
