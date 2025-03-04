package com.cht.suppliesbace.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "department")
public class Department{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "DEPARTMENT_NAME")
    private String departmentName;

    @Column(name = "CODE")
    private String code;

//    a department has a faculty
    @ManyToOne
    @JoinColumn(name = "FACULTY_ID")
    private Faculty faculty;

    public Department() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
}