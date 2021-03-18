package com.smarte.project.service;

import com.smarte.project.model.Department;
import com.smarte.project.model.Employee;
import com.smarte.project.repository.DepartmentRepo;
import com.smarte.project.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    EmployeeRepo employeeRepo;
    @Autowired
    DepartmentRepo departmentRepo;

    @GetMapping("/all")
    List<Employee> all() {
        return (List<Employee>) employeeRepo.findAll();
    }

    @PostMapping(path = "/saveEmp", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {

        Optional<Department> department = departmentRepo.findById(Integer.valueOf(employee.getDepartment().getDeptId()));
        if (department.isPresent()) {
            employee.setDepartment(department.get());
            Employee emp = employeeRepo.save(employee);

            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(emp.getEmpId()).toUri();

            return ResponseEntity.created(location).build();
        }
        return ResponseEntity.badRequest().build();

    }
}
