package com.target.training.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Contact {

        private Integer id;
        private String firstname;
        private String lastname;
        private Gender gender = Gender.FEMALE;
        private String email;
        private String phone;
        private String address;
        private String city = "Bangalore";
        private String state = "Karnataka";
        private Integer pinCode;
        private String country = "India";
        private Date birthDate;


}
