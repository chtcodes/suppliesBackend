package com.cht.suppliesbace.model;

import jakarta.persistence.*;

import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity

@Table(name = "DESIGNATIONS")
public class Designation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;


    @Column(name = "DESIGNATION_NAME")
    private String designationName;

    @Column(name = "GRADE")
    private String grade;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "CODE")
    private String code;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDesignationName() {
        return designationName;
    }

    public void setDesignationName(String designationName) {
        this.designationName = designationName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
