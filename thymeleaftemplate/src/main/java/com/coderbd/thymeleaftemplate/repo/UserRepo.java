package com.coderbd.thymeleaftemplate.repo;


import com.coderbd.thymeleaftemplate.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByEmail(String email);

    User findByMobile(String mobile);

    User findByUserName(String userName);

    User findByUserNameAndPassword(String userName, String password);

    Optional<User> findByUserNameOrEmail(String userName, String email);
}
