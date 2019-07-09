package com.example.Hibernate.entity;


import javax.persistence.*;

@Entity
public class ContactDetail {

    @Id
    @GeneratedValue
    private Long id;
    @Version
    private int version;
    private String telType;
    private String telNumber;


    @ManyToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;


}


