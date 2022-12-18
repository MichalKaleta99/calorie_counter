package com.in28minutes.springboot.myfirstwebapp.caloriecounter;

public class IntroducedProduct {

    private double mass;
    private String productName;

    public IntroducedProduct(){

    }

    public IntroducedProduct(double mass, String productName) {
        this.mass = mass;
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "IntroducedProduct{" +
                "mass=" + mass +
                ", productName='" + productName + '\'' +
                '}';
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }
}
