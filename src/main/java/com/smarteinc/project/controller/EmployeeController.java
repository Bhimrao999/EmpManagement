package com.smarteinc.project.controller;

import com.smarteinc.project.model.Department;
import com.smarteinc.project.model.Employee;
import com.smarteinc.project.repository.DepartmentRepository;
import com.smarteinc.project.repository.EmployeeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    final EmployeeRepository employeeRepository;

    final DepartmentRepository departmentRepository;

    public EmployeeController(
            EmployeeRepository employeeRepository,
            DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    @GetMapping
    List<Employee> getAll() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @PostMapping("/")
    public ResponseEntity<Object> addEmployee(@RequestBody Employee employeeAddRequest) {

        Optional<Department> department = departmentRepository
                .findById(employeeAddRequest.getDepartment().getId());
        if (department.isPresent()) {
            //persist in database
            employeeAddRequest.setDepartment(department.get());

            Employee savedEmployee = saveEmployeeInDepartment(employeeAddRequest, department);

            // Return in location header the new employee ID
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(savedEmployee.getId()).toUri();

            return ResponseEntity.created(location).build();
        }
        return ResponseEntity.badRequest().build();
    }

    private Employee saveEmployeeInDepartment(Employee employeeAddRequest, Optional<Department> department) {
        employeeAddRequest.setDepartment(department.get());
        return employeeRepository.save(employeeAddRequest);
    }

//    @GetMapping("/getAllEmployee")
//    public List<Employee> getEmployeeAgeAboveFourty() {
//
//        return (List<Employee>).s employeeRepository.findAll().forEach();
//    }

}
