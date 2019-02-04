package com.arefin.sunshinefarm.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employees")
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "mobile", unique = true)
    private String mobile;

    @Column(name = "starting_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="MM-dd-yyyy")
    private Date startingDate;

    @Column(name = "monthly_salary")
    private Double monthlySalary;

    @ManyToOne
    @JoinColumn(name = "designation_id", nullable = false)
    private Designation designation;

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public Designation getDesignation() {
        return designation;
    }

    public void setDesignation(Designation designation) {
        this.designation = designation;
    }

    public Double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(Double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }
}
