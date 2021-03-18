package com.smarte.project.service;

import com.smarte.project.model.Department;
import com.smarte.project.model.Employee;
import com.smarte.project.repository.DepartmentRepo;
import com.smarte.project.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.websocket.server.PathParam;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    DepartmentRepo departmentRepo;

    @Autowired
    EmployeeRepo employeeRepo;

    @GetMapping("/all")
    List<Department> all() {
        return (List<Department>) departmentRepo.findAll();
    }

    @GetMapping("/all{id}")
    ResponseEntity<Object> addEmployee(@RequestBody Employee employee, @PathParam("id") int id) {

        Optional<Employee> emp = employeeRepo.findById(Integer.valueOf(employee.getDepartment().getDeptId()));

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(employee.getEmpId()).toUri();
        return ResponseEntity.created(location).build();
    }


    @PostMapping(path = "/saveDept", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addDepartment(@RequestBody Department department) {
        Department dep = departmentRepo.save(department);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dep.getDeptId()).toUri();

        return ResponseEntity.created(location).build();

    }
}
