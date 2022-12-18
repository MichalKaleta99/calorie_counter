package com.in28minutes.springboot.myfirstwebapp.caloriecounter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="product")

public class Product {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String category;
    private double protein;
    private double fat;
    private double carbs;
    private double salt;
    private double kcal;

    public Product(int id, String name, String category, double protein, double fat, double carbs, double salt, double kcal) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.protein = protein;
        this.fat = fat;
        this.carbs = carbs;
        this.salt = salt;
        this.kcal = kcal;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", protein=" + protein +
                ", fat=" + fat +
                ", carbs=" + carbs +
                ", salt=" + salt +
                ", kcal=" + kcal +
                '}';
    }

    public Product(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getCarbs() {
        return carbs;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    public double getSalt() {
        return salt;
    }

    public void setSalt(double salt) {
        this.salt = salt;
    }

    public double getKcal() {
        return kcal;
    }

    public void setKcal(double kcal) {
        this.kcal = kcal;
    }

}
