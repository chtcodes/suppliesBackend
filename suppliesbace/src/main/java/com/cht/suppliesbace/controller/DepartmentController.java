package com.cht.suppliesbace.controller;

import com.cht.suppliesbace.model.Department;
import com.cht.suppliesbace.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
@CrossOrigin(origins = "http://localhost:4200")
public class DepartmentController{

    @Autowired
    private DepartmentService departmentService;

    //get all
    @GetMapping
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    //get by id
    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable Long id){
        return departmentService.getDepartmentById(id);
    }

    //save
    @PostMapping
    public Department createDepartment(@RequestBody Department details){
        return departmentService.saveDepartment(details);
    }

    //update
    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable Long id, @RequestBody Department details){
        return departmentService.updateDepartment(id,details);
    }

    //delete
    @DeleteMapping("/{id}")
    public String deleteDepartment(@PathVariable Long id){
       departmentService.deleteDepartment(id);
       return "The department deleted successfully!";
    }

}