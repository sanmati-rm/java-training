package com.target.training.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Triangle implements Shape{

    private double height;
    private double breadth;

    @Override
    public double getArea() {
        return 0.5*height*breadth;
    }
}
