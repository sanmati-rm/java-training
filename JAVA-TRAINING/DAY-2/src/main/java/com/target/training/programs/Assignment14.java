package com.target.training.programs;

import com.target.training.model.Circle2;
import com.target.training.model.Rectangle;
import com.target.training.model.Shape;
import com.target.training.model.Square;

public class Assignment14 {

    public static void main(String[] args) {

        Shape[] shapes = {
                new Circle2("blue", true, 10.0),
                new Circle2(10.0),
                new Circle2(),
                new Rectangle(2.0, 2.0, "green", false),
                new Rectangle(4.0, 5.0),
                new Rectangle(),
                new Square(5.0, "green", false),
                new Square(10.0),
                new Rectangle(),
                new Shape()
        };

        for (Shape shape : shapes) {
            System.out.println(shape);
            //if(shape instanceof Circle2)
            //    System.out.println(((Circle2)shape).getRadius());

        }

    }
}
