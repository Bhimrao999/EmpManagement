package com.example.demo.dao;

import com.example.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpDao extends JpaRepository<Employee,Integer> {
}
