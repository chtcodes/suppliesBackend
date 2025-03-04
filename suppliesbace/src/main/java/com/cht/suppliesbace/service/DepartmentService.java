package com.cht.suppliesbace.service;

import com.cht.suppliesbace.exceptions.ResourceNotFoundException;
import com.cht.suppliesbace.model.Department;
import com.cht.suppliesbace.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DepartmentService{
     @Autowired
    private DepartmentRepository departmentRepository;


     //get all
    public List<Department> getAllDepartments(){
        return departmentRepository.findAll();
    }

    //get by id
    public Department getDepartmentById(Long id){
        return departmentRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Department not found!"));
    }

    //save department
    public Department saveDepartment(Department department){
        return departmentRepository.save(department);
    }


    //update department
    public Department updateDepartment(Long id, Department details){
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department doesn't exist!"));
        department.setDepartmentName(details.getDepartmentName());
        department.setCode(details.getCode());
        department.setFaculty(details.getFaculty());
        return  departmentRepository.save(department);
    }


    //delete department

    public void deleteDepartment(Long id){
        departmentRepository.deleteById(id);
    }






}