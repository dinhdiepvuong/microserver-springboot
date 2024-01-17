package com.diepvuong.department.controller;

import com.diepvuong.department.entity.Department;
import com.diepvuong.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/api/v1/department")
    public ResponseEntity<Department> saveDepartment(@RequestBody Department department){
        return new ResponseEntity<>(departmentService.saveDepartment(department), HttpStatus.CREATED);
    }

    @GetMapping("/api/v1/department/{departmentId}")
    public ResponseEntity<Department> findDepartmentById(@PathVariable("departmentId") Long departmentId){
        return new ResponseEntity<>(departmentService.findDepartmentById(departmentId), HttpStatus.OK);
    }
}
