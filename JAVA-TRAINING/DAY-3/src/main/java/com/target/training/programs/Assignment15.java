package com.target.training.programs;

import com.target.training.model.Movable;
import com.target.training.model.MovableCircle;
import com.target.training.model.MovablePoint;
import com.target.training.model.MovableRectangle;

public class Assignment15 {
    public static void main(String[] args) {

        Movable m1 = new MovablePoint(5, 6, 10, 15);     // upcast
        System.out.println(m1);
        m1.moveLeft();
        System.out.println(m1);

        Movable m2 = new MovableCircle(1, 2, 3, 4, 20);  // upcast
        System.out.println(m2);
        m2.moveRight();
        System.out.println(m2);


        Movable m3 = new MovableRectangle(1, 2, 3, 4, 25, 35);  // upcast
        System.out.println(m3);
        m3.moveUp();
        System.out.println(m3);

    }
}
