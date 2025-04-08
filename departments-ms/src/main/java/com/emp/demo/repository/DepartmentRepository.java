package com.emp.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.demo.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department,Integer>
{
	

}
