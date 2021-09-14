package com.target.training.model;

public class Cylinder extends Circle{

    private double height = 1.0;


    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }


    public Cylinder(){

    }

    public Cylinder(double radius){
        super(radius);
    }

    public Cylinder(double radius, double height){
        super(radius);
        setHeight(height);

    }

    public Cylinder(double radius, double height, String color){
        super(radius,color);
        setHeight(height);

    }

    public double getVolume(){
        double radius = super.getRadius();
        return (3.14*radius*radius*height);
    }


}
