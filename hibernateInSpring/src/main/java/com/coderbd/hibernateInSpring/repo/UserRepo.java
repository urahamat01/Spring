package com.coderbd.hibernateInSpring.repo;


import com.coderbd.hibernateInSpring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findByFileName(String filename);
}
