package com.in28minutes.springboot.myfirstwebapp.caloriecounter;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    public Product findByName(String name);

    public List<Product> findAll();



}