package com.example.SpringThembnil;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
    //select * from role where roleName=?
    Role findByRoleName(String roleName);

}
