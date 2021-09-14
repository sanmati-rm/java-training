package com.target.training.model;

public class Circle2 extends Shape{

    private double radius = 1.0;

    public Circle2(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    public Circle2(){

    }

    public Circle2(double radius){
        this.radius=radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }


    public double getArea(){
        return (3.14*radius*radius);
    }

    public double getPerimeter(){
        return (2*3.14*radius);
    }

    @Override
    public String toString() {
        return "Circle{" +
                super.toString() +
                "radius=" + radius +
                "Area: " + getArea() + "," +
                "Perimeter: " + getPerimeter() + "," +
                '}';
    }
}
