package com.cht.suppliesbace.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "FACULTY")
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "FACULTY_NAME")
    private String facultyName;

    @Column(name = "CODE")
    private String code;

    @OneToMany(mappedBy = "faculty")
    private List<Department> departments;



    public Faculty() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
