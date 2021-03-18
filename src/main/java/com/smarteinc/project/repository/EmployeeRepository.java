package com.smarteinc.project.repository;

import com.smarteinc.project.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {
}
