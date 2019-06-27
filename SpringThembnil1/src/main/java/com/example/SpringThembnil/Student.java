package com.example.SpringThembnil;


import javax.persistence.*;

@Entity
@Table(name = "stu")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Student(String name) {

        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public Student() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
