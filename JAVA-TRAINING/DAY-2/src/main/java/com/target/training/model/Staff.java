package com.target.training.model;


public class Staff extends Person{

    private String school;
    private double pay;

    public Staff(String name, String addr, String school, double pay) {
        super(name, addr);
        this.school = school;
        this.pay = pay;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    @Override
    public String toString() {
        return "Staff{" +
                super.toString() +
                "school='" + school + '\'' +
                ", pay=" + pay +
                '}';
    }
}
