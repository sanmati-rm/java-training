package com.target.training.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="contacts")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstname;
    private String lastname;
    private Gender gender;
    private String email;
    private String phone;
    private String address;
    private String city = "Bangalore";
    private String state = "Karnataka";
    private String pincode;
    private String country = "India";
    @Column(name="birth_date")
    private Date birthDate;

    public Contact(String firstname, String lastname, Gender gender, String email, String phone, String address, String city, String state, String pincode, String country, Date birthDate) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
        this.country = country;
        this.birthDate=birthDate;
    }
}