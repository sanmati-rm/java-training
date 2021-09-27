package com.target.training;

public class Calculator {

    public double add(Object...nums){

        Double sum =0.;

        for(Object n: nums){
            sum+= (n==null? 0. : Double.valueOf(n.toString()));
        }
        return sum;
    }

}
