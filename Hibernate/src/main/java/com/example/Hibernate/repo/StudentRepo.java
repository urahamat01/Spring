package com.example.Hibernate.repo;

import com.example.Hibernate.entity.Contact;
import com.example.Hibernate.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    Iterable<Student> findAllByDepartment(Deprecated deprecated);

    Iterable<Student> find


}
