package com.example.Hibernate.repo;


import com.example.Hibernate.entity.Contact;
import com.example.Hibernate.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
