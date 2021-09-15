package com.target.training.model;

public class MovableRectangle implements Movable{

    private MovablePoint topLeft;
    private MovablePoint bottomRight;

    @Override
    public void moveUp() {

    }

    @Override
    public void moveDown() {

    }

    @Override
    public void moveRight() {

    }

    @Override
    public void moveLeft() {

    }

    @Override
    public String toString() {
        return "MovableRectangle{" +
                "topLeft=" + topLeft +
                ", bottomRight=" + bottomRight +
                '}';
    }

    public MovableRectangle(int x1, int y1, int x2, int y2,int xSpeed, int ySpeed) {
        topLeft = new MovablePoint(x1,y1,xSpeed,ySpeed);
        bottomRight = new MovablePoint(x2,y2,xSpeed,ySpeed);
    }
}
