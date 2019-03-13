package com.arefin.sunshinefarm.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    @NotBlank(message = "Enter your username")
    private String userName;

    @Column(name = "password")
    @NotBlank(message = "Enter your password")
    private String password;

    @Column(name = "email", unique = true)
    @NotBlank(message = "Enter your email")
    private String email;

    @Column(name = "mobile", unique = true)
    @NotBlank(message = "Enter your mobile")
    private String mobile;

    @Column(name = "name")
    @NotBlank(message = "Enter your Name")
    private String name;

    @Column(name = "registration_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date registrationDate;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "u_id"),
            inverseJoinColumns = @JoinColumn(name = "r_id")
    )
    private Set<Role> roles;

    public User() {
    }

    public User(@NotBlank(message = "Enter your username") String userName, @NotBlank(message = "Enter your password") String password, @NotBlank(message = "Enter your email") String email, @NotBlank(message = "Enter your mobile") String mobile, @NotBlank(message = "Enter your firstName") String name, Date registrationDate, Set<Role> roles) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.mobile = mobile;
        this.name = name;
        this.registrationDate = registrationDate;
        this.roles = roles;
    }

    public User(User user){
        this.userName = user.userName;
        this.password = user.password;
        this.email = user.email;
        this.mobile = user.mobile;
        this.name = user.name;
        this.registrationDate = user.registrationDate;
        this.roles = user.roles;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(password, user.password) &&
                Objects.equals(email, user.email) &&
                Objects.equals(mobile, user.mobile) &&
                Objects.equals(name, user.name) &&
                Objects.equals(registrationDate, user.registrationDate) &&
                Objects.equals(roles, user.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, password, email, mobile, name, registrationDate, roles);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", firstName='" + name + '\'' +
                ", registrationDate=" + registrationDate +
                ", role=" + roles +
                '}';
    }
}
