package com.target.training.programs;

import com.target.training.model.Circle;
import com.target.training.model.Cylinder;

public class Assignment12 {

    public static void main(String[] args) {

        Circle[] circles = {
                new Cylinder(12.34),
                new Cylinder(12.34, 10.0),
                new Cylinder(12.34, 10.0, "blue")
        };

        for (Circle circle:circles
             ) {
            System.out.println(circle);
            //System.out.println(circle.g);
        }

    }
}
