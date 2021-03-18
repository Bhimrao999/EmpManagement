package com.smarte.project.repository;

import com.smarte.project.model.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepo extends CrudRepository<Department,Integer> {
}
