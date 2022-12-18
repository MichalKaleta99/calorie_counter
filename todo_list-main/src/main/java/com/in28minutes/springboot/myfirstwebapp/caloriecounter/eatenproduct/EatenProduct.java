package com.in28minutes.springboot.myfirstwebapp.caloriecounter.eatenproduct;

import com.in28minutes.springboot.myfirstwebapp.caloriecounter.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Entity
@Table(name="eatenProduct")
public class EatenProduct {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private double protein;
    private double fat;
    private double carbs;
    private double salt;
    private double kcal;
    private LocalDate dateEaten;
    private double mass;
    public EatenProduct(){}

    public EatenProduct(int id, String name, double protein, double fat, double carbs, double salt, double kcal, LocalDate dateEaten, double mass) {
        this.id = id;
        this.name = name;
        this.protein = protein;
        this.fat = fat;
        this.carbs = carbs;
        this.salt = salt;
        this.kcal = kcal;
        this.dateEaten = dateEaten;
        this.mass = mass;
    }

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

    public LocalDate getDateEaten() {
        return dateEaten;
    }

    public void setDateEaten(LocalDate dateEaten) {
        this.dateEaten = dateEaten;
    }

    public double getmass() {
        return mass;
    }

    public void setmass(double mass) {
        this.mass = mass;
    }

    @Override
    public String toString() {
        return "EatenProduct{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", protein=" + protein +
                ", fat=" + fat +
                ", carbs=" + carbs +
                ", salt=" + salt +
                ", kcal=" + kcal +
                ", dateEaten=" + dateEaten +
                ", mass=" + mass +
                '}';
    }

    public EatenProduct addEatenProduct(Product product, double mass){
        EatenProduct eatenProduct = new EatenProduct();
        eatenProduct.setName(product.getName());
        eatenProduct.setProtein(product.getProtein()*mass/100);
        eatenProduct.setFat(product.getFat()*mass/100);
        eatenProduct.setCarbs(product.getCarbs()*mass/100);
        eatenProduct.setSalt(product.getSalt()*mass/100);
        eatenProduct.setKcal(product.getKcal()*mass/100);
        eatenProduct.setDateEaten(LocalDate.now());
        eatenProduct.setmass(mass);
        return eatenProduct;
    }

    public Map<String, Double> sumDoubleFields(List<EatenProduct> eatenProducts) throws IllegalAccessException {
        Map<String, Double> fieldSums = new HashMap<>();
        for (EatenProduct eatenProduct : eatenProducts) {
            Field[] fields = eatenProduct.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.getType() == double.class) {
                    field.setAccessible(true);
                    String fieldName = field.getName();
                    double fieldValue = field.getDouble(eatenProduct);
                    fieldSums.put(fieldName, fieldSums.getOrDefault(fieldName, 0.0) + fieldValue);
                }
            }
        }

        // round all values in the fieldSums map to 2 decimal places
        for (Map.Entry<String, Double> entry : fieldSums.entrySet()) {
            String fieldName = entry.getKey();
            double fieldValue = entry.getValue();
            double roundedValue = (double) Math.round(fieldValue * Math.pow(10, 2)) / Math.pow(10, 2);
            fieldSums.put(fieldName, roundedValue);
        }

        return fieldSums;
    }



}
