package com.target.training.model;

public class MovablePoint implements Movable{

    int x;
    int y;
    int xSpeed;
    int ySpeed;

    public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    @Override
    public String toString() {
        return "MovablePoint{" +
                "x=" + x +
                ", y=" + y +
                ", xSpeed=" + xSpeed +
                ", ySpeed=" + ySpeed +
                '}';
    }

    @Override
    public void moveUp() {
        y -= ySpeed;
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
}
