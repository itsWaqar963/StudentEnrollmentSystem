package com.springcore.student.enrollment.system;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

public class Student {

    private int id;
    private String name;
    private List<String> courses;

    public Student() {
    }

    public Student(int id, String name, List<String> courses) {
        this.id = id;
        this.name = name;
        this.courses = courses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    @PostConstruct
    public void init() {
        System.out.println("Student bean is initialized.");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Student bean is being destroyed.");
    }
}
