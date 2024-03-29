package com.coderbd.thymeleaftemplate.repo;


import com.coderbd.thymeleaftemplate.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByRoleAndRolename(String rolename);

    Role findByRolename(String rolename);
}
