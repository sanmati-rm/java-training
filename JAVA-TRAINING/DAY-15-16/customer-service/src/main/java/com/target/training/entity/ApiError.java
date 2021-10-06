package com.target.training.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Data
@XmlRootElement
@NoArgsConstructor
@AllArgsConstructor
public class ApiError {
    private HttpStatus httpStatus;
    private Date timestamp;
    private String message;
}
