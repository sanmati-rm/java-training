package com.target.training.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name="EMPLOYEES")
public class Employee {

    @Id
    @GeneratedValue(generator = "increment")
    @Column(name="EMPLOYEE_ID")
    private Integer employeeId;

    @Column(name="FIRST_NAME")
    private String firstname;

    @Column(name="LAST_NAME")
    private String lastname;

    private String title;

    @Column(name="TITLE_OF_COURTESY")
    private String titleOfCourtesy;

    @Column(name="BIRTH_DATE")
    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDate;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="HIRE_DATE")
    private Date hireDate;

    private String address;
    private String city;
    private String region;

    @Column(name="POSTAL_CODE")
    private String postalCode;
    private String country;

    @Column(name="HOME_PHONE")
    private String homePhone;
    private String extension;

    @Column(name="Photo")
    private byte[] photo;
    @Lob
    private String notes;

    @Column(name="REPORTS_TO")
    private Integer reportsTo;

}