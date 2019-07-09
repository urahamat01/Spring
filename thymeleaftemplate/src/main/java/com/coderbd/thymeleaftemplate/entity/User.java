package com.coderbd.thymeleaftemplate.entity;


import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotEmpty(message = "Please enter username")
    @Column(name = "username", unique = true)
    private String userName;

    private String photo;

    @NotEmpty(message = "Place enter password")
    @Column(name = "password")
    @Size(min = 0, message = "At least 0 Characters")
    private String password;


    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;


    @Email
    @NotEmpty(message = "please enter Email Address")
    @Column(name = "email", unique = true)
    private String email;


    @Length(min = 11, message = "your mobile have at least 11 characters")
    @NotEmpty(message = "please enter mobile Address")
    @Column(name = "mobile", unique = true)
    private String mobile;


    @Column(name = "joining_date")
    private Date joiningDate;


    @Column(name = "is_activated")
    private String isActivated;


    @Size(min = 0, max = 100)
    @Column(name = "activation_key")
    private String activationKey;

    @Size(min = 0, max = 100)
    @Column(name = "reset_pass_key")
    private String resetPasswordKey;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )

    private Set<Role> roles;

    public User(@NotEmpty(message = "Please enter username") String userName, @NotEmpty(message = "Place enter password") @Size(min = 0, message = "At least 0 Characters") String password, String firstName, String lastName, @Email @NotEmpty(message = "please enter Email Address") String email, @Length(min = 11, message = "your mobile have at least 11 characters") @NotEmpty(message = "please enter mobile Address") String mobile, Date joiningDate, String isActivated, @Size(min = 0, max = 100) String activationKey, @Size(min = 0, max = 100) String resetPasswordKey, Set<Role> roles) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobile = mobile;
        this.joiningDate = joiningDate;
        this.isActivated = isActivated;
        this.activationKey = activationKey;
        this.resetPasswordKey = resetPasswordKey;
        this.roles = roles;
    }

    public User(User user) {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(email, user.email) &&
                Objects.equals(mobile, user.mobile) &&
                Objects.equals(roles, user.roles);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public void setIsActivated(String isActivated) {
        this.isActivated = isActivated;
    }

    public String getIsActivated() {
        return isActivated;
    }


    public String getActivationKey() {
        return activationKey;
    }

    public void setActivationKey(String activationKey) {
        this.activationKey = activationKey;
    }

    public String getResetPasswordKey() {
        return resetPasswordKey;
    }

    public void setResetPasswordKey(String resetPasswordKey) {
        this.resetPasswordKey = resetPasswordKey;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}



