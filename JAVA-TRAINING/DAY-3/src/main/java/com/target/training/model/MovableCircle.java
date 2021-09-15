package com.target.training.model;

public class MovableCircle implements Movable{

    private int radius;

    private MovablePoint center;

    public MovableCircle(int radius, int x, int y, int xSpeed, int ySpeed) {
        this.radius = radius;
        center = new MovablePoint(x,y,xSpeed,ySpeed);
    }

    @Override
    public String toString() {
        return "MovableCircle{" +
                "radius=" + radius +
                ", point=" + center +
                '}';
    }

    @Override
    public void moveUp() {
        center.y -= center.ySpeed;
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
