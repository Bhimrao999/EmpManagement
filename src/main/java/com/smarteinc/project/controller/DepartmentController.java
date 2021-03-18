package com.smarteinc.project.controller;

import com.smarteinc.project.model.Department;
import com.smarteinc.project.repository.DepartmentRepository;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    final DepartmentRepository repository;

    public DepartmentController(DepartmentRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    List<Department> getAll() {
        return (List<Department>) repository.findAll();
    }

    @GetMapping("{id}")
    ResponseEntity<Department> get(@PathVariable("id") Long id) {

        Optional<Department> department = repository
            .findById(id);
        if(department.isPresent()) {
            return ResponseEntity.ok(department.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Object> add(@RequestBody Department department) {
        Department dep = repository.save(department);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dep.getId()).toUri();

        return ResponseEntity.created(location).build();

    }
}
