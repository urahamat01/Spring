package com.example.Hibernate.entity;

import javax.persistence.*;
import java.util.Set;


@Entity
public class Hobby {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToMany
    @JoinTable(name =  "hobby_id", joinColumns = @JoinColumn(name = "hobby_id"),
    inverseJoinColumns = @JoinColumn(name = "contact_id"))
    private Set<Contact> contacts;
}
