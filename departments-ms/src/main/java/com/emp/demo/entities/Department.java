	package com.emp.demo.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deptId;
    private String name;
    private String location;
    private String employeeCount;
}