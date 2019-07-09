package com.example.Hibernate.entity;


import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "contact")
public class Contact {


    @OneToMany(mappedBy = "contact")
    private Set<ContactDetail> contactDetailSet;
    @OneToMany(mappedBy = "contacts")
    private Set<Hobby> hobbies;
    @OneToOne
    @JoinColumn(name = "student", nullable = false)
    private Student students;

    public Contact() {
    }

    public Set<ContactDetail> getContactDetailSet() {
        return contactDetailSet;
    }

    public void setContactDetailSet(Set<ContactDetail> contactDetailSet) {
        this.contactDetailSet = contactDetailSet;
    }

    public Set<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(Set<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

    public Student getStudents() {
        return students;
    }

    public void setStudents(Student students) {
        this.students = students;
    }

    @Entity
    public static class Department {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "dep_name", nullable = false, unique = true)
        @Size(min = 3, max = 20)
        private String name;

        public Long getId() {
            return id;
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
}
