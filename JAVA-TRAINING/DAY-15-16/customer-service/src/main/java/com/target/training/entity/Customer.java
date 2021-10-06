package com.target.training.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="CUSTOMERS")
public class Customer {

    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "CUSTOMER_ID")
    private String customerId;
    @Column(name = "COMPANY_NAME")
    private String companyName;
    @Column(name = "CONTACT_NAME")
    private String contactName;
    @Column(name = "CONTACT_TITLE")
    private String contactTitle;
    private String address;
    private String city;
    private String region;
    @Column(name = "POSTAL_CODE")
    private String postalCode;
    private String country;
    private String phone;
    private String fax;
}